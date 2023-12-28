package com.example.achillesziekenhuis.data

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.achillesziekenhuis.data.database.AgendaslotDao
import com.example.achillesziekenhuis.data.database.asDbAgendaslot
import com.example.achillesziekenhuis.data.database.asDomainAgendaslots
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.ListAgendaslot
import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.asDomainObjects
import com.example.achillesziekenhuis.network.getAgendaslotByRizivAndDateAsFlow
import com.example.achillesziekenhuis.network.getAgendaslotsByRRNAsFlow
import com.example.achillesziekenhuis.network.getAgendaslotsDailyAsFlow
import com.example.achillesziekenhuis.network.getDoktersAsFlow
import com.example.achillesziekenhuis.workerUtils.WifiNotificationWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException
import java.time.LocalDateTime
import java.util.UUID

interface AgendaslotRepository {

    fun getDailyAgendaslots(): Flow<List<ListAgendaslot>>

    fun getByRRN(rijksregisternummer: String): Flow<List<Agendaslot>>

    fun getByRizivAndDate(rizivNummer: String, startTime: String): Flow<List<Agendaslot>>

    suspend fun insertAgendaslot(agendaslot: Agendaslot)

    suspend fun refresh()

    var wifiWorkInfo: Flow<WorkInfo>

}

class CachingAgendaslotRepository(
    private val agendaslotDao: AgendaslotDao,
    private val agendaslotApiService: AgendaslotApiService,
    context: Context,
) : AgendaslotRepository {

    override fun getDailyAgendaslots(): Flow<List<ListAgendaslot>> {
        return agendaslotApiService.getAgendaslotsDailyAsFlow().map {
            it.asDomainObjects()
        }
    }

    override fun getByRRN(rijksregisternummer: String): Flow<List<Agendaslot>> {
        return agendaslotDao.getItemByRRN(rijksregisternummer).map {
            it.asDomainAgendaslots()
        }.onEach {
            if (it.isEmpty()) {
                refresh()
            }
        }
    }

    // this repo conaints logic to refresh the tasks (remote)
    // sometimes that logic is written in a 'usecase'
    override fun getByRizivAndDate(rizivNummer: String, startTime: String): Flow<List<Agendaslot>> = flow {
        // checkes the array of items comming in
        // when empty --> tries to fetch from API
        emit( agendaslotApiService.getAgendaslotByRizivAndDate(rizivNummer, startTime).asDomainObjects() )
    }

    override suspend fun insertAgendaslot(agendaslot: Agendaslot) {
        agendaslotDao.insert(agendaslot.asDbAgendaslot())
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
            agendaslotApiService.getAgendaslotsByRRNAsFlow("00.12.01-197.80").asDomainObjects().collect {
                    value ->
                for (agendaslot in value) {
                    Log.i("TEST", "refresh: $value")
                    insertAgendaslot(agendaslot)
                }
            }
        } catch (e: SocketTimeoutException) {
            // log something
        }
    }
}
