package com.example.achillesziekenhuis.data

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.achillesziekenhuis.data.database.GebruikerDao
import com.example.achillesziekenhuis.data.database.asDbGebruiker
import com.example.achillesziekenhuis.data.database.asDomainGebruiker
import com.example.achillesziekenhuis.data.database.asDomainGebruikers
import com.example.achillesziekenhuis.model.Gebruiker
import com.example.achillesziekenhuis.network.GebruikerApiService
import com.example.achillesziekenhuis.network.asDomainAgendaslots
import com.example.achillesziekenhuis.network.getGebruikersAsFlow
import com.example.achillesziekenhuis.workerUtils.WifiNotificationWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.SocketTimeoutException
import java.util.UUID

/**
 * Repository for fetching [Gebruiker]s from the network and storing them on disk.
 */
interface GebruikersRepository {

    /**
     * Returns all gebruikers from the database.
     */
    fun getAllGebruikers(): Flow<List<Gebruiker>>

    /**
     * Returns a gebruiker by their auth0id.
     */
    fun getGebruikerByAuth0id(auth0id: String): Flow<Gebruiker>

//    fun getGebruikerByAuth0id(auth0id: String): Gebruiker

    /**
     * Inserts a gebruiker into the database.
     */
    suspend fun insertGebruiker(gebruiker: Gebruiker)

    /**
     * Refreshes the gebruikers in the database.
     */
    suspend fun refresh()

    /**
     * Returns the work info of the wifi notification worker.
     */
    var wifiWorkInfo: Flow<WorkInfo>
}

/**
 * Concrete implementation of the [GebruikersRepository] interface. This class is responsible for
 * fetching gebruikers from the network and storing them on disk.
 */
class CachingGebruikersRepository(
    private val gebruikerDao: GebruikerDao,
    private val gebruikerApiService: GebruikerApiService,
    context: Context,
): GebruikersRepository {

    override fun getAllGebruikers(): Flow<List<Gebruiker>> {
        return gebruikerDao.getAllGebruikers().map {
            it.asDomainGebruikers()
        }
    }

    override fun getGebruikerByAuth0id(auth0id: String): Flow<Gebruiker> {
        return gebruikerDao.getGebruikerByAuth0id(auth0id).map {
            it.asDomainGebruiker()
        }
//        return gebruikerDao.getGebruikerByAuth0id(auth0id).asDomainGebruiker()
    }

    override suspend fun insertGebruiker(gebruiker: Gebruiker) {
        gebruikerDao.insert(gebruiker.asDbGebruiker())
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
            gebruikerApiService.getGebruikersAsFlow().asDomainAgendaslots().collect {
                    value ->
                for (gebruiker in value) {
                    Log.i("TEST", "refresh: $value")
                    insertGebruiker(gebruiker)
                }
            }
        } catch (e: SocketTimeoutException) {
            // log something
        }
    }

}