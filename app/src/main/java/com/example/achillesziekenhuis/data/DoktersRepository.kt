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
import com.example.achillesziekenhuis.network.asDomainAgendaslots
import com.example.achillesziekenhuis.network.getDoktersAsFlow
import com.example.achillesziekenhuis.workerUtils.WifiNotificationWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.SocketTimeoutException
import java.util.UUID

interface DoktersRepository {
    // all dokters from datasource
    fun getDokters(): Flow<List<Dokter>>

    fun getAfdelingen(): Flow<List<String>>

    fun getDoktersByAfdeling(afdeling: String): Flow<List<Dokter>>

    suspend fun insertDokter(dokter: Dokter)

    suspend fun updateDokter(dokter: Dokter)

    suspend fun deleteDokter(dokter: Dokter)

    suspend fun refresh()

    var wifiWorkInfo: Flow<WorkInfo>
}

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
            dokterApiService.getDoktersAsFlow().asDomainAgendaslots().collect {
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
