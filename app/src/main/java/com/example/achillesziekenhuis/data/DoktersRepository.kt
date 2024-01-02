package com.example.achillesziekenhuis.data

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.achillesziekenhuis.data.database.DokterDao
import com.example.achillesziekenhuis.data.database.asDbDokter
import com.example.achillesziekenhuis.data.database.asDomainDokters
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.network.DokterApiService
import com.example.achillesziekenhuis.network.asDomainDomaindokters
import com.example.achillesziekenhuis.network.getDoktersAsFlow
import com.example.achillesziekenhuis.workerUtils.WifiNotificationWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.SocketTimeoutException
import java.util.UUID

/**
 * Repository for fetching [Dokter]s from the network and storing them on disk.
 */
interface DoktersRepository {
    /**
     * Returns all dokters from the database.
     */
    fun getDokters(): Flow<List<Dokter>>

    /**
     * Returns all afdelingen from the database.
     */
    fun getAfdelingen(): Flow<List<String>>

    /**
     * Returns all dokters from a specific afdeling from the database.
     */
    fun getDoktersByAfdeling(afdeling: String): Flow<List<Dokter>>

    /**
     * Inserts a dokter into the database.
     */
    suspend fun insertDokter(dokter: Dokter)

    /**
     * Updates a dokter in the database.
     */
    suspend fun updateDokter(dokter: Dokter)

    /**
     * Deletes a dokter from the database.
     */
    suspend fun deleteDokter(dokter: Dokter)

    /**
     * Refreshes the dokters in the database.
     */
    suspend fun refresh()

    /**
     * Returns the work info of the wifi notification worker.
     */
    var wifiWorkInfo: Flow<WorkInfo>
}

/**
 * Concrete implementation of the [DoktersRepository] interface. This class is responsible for
 * fetching dokters from the network and storing them on disk.
 */
class CachingDokterRepository(
    private val dokterDao: DokterDao,
    private val dokterApiService: DokterApiService,
    context: Context,
) : DoktersRepository {

    // this repo contains logic to refresh the tasks (remote)
    // sometimes that logic is written in a 'usecase'
    override fun getDokters(): Flow<List<Dokter>> {
        // checks the array of items coming in
        // when empty --> tries to fetch from API
        return dokterDao.getAllDokters().map {
            it.asDomainDokters()
        }
    }

    override fun getAfdelingen(): Flow<List<String>> {
        val afdelingen = dokterDao.getAfdelingen()
        Log.d("Afdelingen in repo", afdelingen.toString())
        return afdelingen
    }

    override fun getDoktersByAfdeling(afdeling: String): Flow<List<Dokter>> {
        return dokterDao.getDoktersByAfdeling(afdeling).map {
            it.asDomainDokters()
        }
    }

    override suspend fun insertDokter(dokter: Dokter) {
        dokterDao.insert(dokter.asDbDokter())
    }

    override suspend fun updateDokter(dokter: Dokter) {
        dokterDao.update(dokter.asDbDokter())
    }

    override suspend fun deleteDokter(dokter: Dokter) {
        dokterDao.delete(dokter.asDbDokter())
    }

    private var workID = UUID(1, 2)

    // the manager is private to the repository
    private val workManager = WorkManager.getInstance(context)

    // the info function is public
    override var wifiWorkInfo: Flow<WorkInfo> =
        workManager.getWorkInfoByIdFlow(workID)

    override suspend fun refresh() {
        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val requestBuilder = OneTimeWorkRequestBuilder<WifiNotificationWorker>()
        val request = requestBuilder.setConstraints(constraints).build()
        workManager.enqueue(request)
        wifiWorkInfo = workManager.getWorkInfoByIdFlow(request.id)

        // note the actual api request still uses coroutines
        try {
            dokterApiService.getDoktersAsFlow().asDomainDomaindokters().collect {
                    value ->
                for (dokter in value) {
                    Log.i("TEST", "refresh: $value")
                    insertDokter(dokter)
                }
            }
        } catch (e: SocketTimeoutException) {
            // log something
        }
    }
}
