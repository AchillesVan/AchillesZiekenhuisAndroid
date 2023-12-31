package com.example.achillesziekenhuis.database

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.achillesziekenhuis.data.CachingAgendaslotRepository
import com.example.achillesziekenhuis.data.database.AgendaslotDao
import com.example.achillesziekenhuis.data.database.DbAgendaslot
import com.example.achillesziekenhuis.data.database.asDbAgendaslot
import com.example.achillesziekenhuis.data.database.asDomainAgendaslot
import com.example.achillesziekenhuis.fake.FakeApiAgendaslotService
import com.example.achillesziekenhuis.fake.FakeDataSource
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.ListAgendaslot
import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.network.asDomainAgendaslot
import com.example.achillesziekenhuis.network.asDomainListAgendaslots
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ApiAgendaslotRepositoryTest {

    private lateinit var service: AgendaslotApiService
    private lateinit var agendaslotDao: AgendaslotDao
    private lateinit var db: TestDatabase
    private lateinit var context: Context
    private lateinit var repository: CachingAgendaslotRepository

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        db = TestDatabase.getDatabase(context)
        agendaslotDao = db.agendaslotDao()
        service = FakeApiAgendaslotService()
        repository = CachingAgendaslotRepository(
            agendaslotDao,
            service,
            context
        )
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun apiAgendaslotRepository_getDailyAgendaslots_verifyAgendaslotsList() = runBlocking {
        var list: List<ListAgendaslot> = emptyList()

        repository.getDailyAgendaslots().collect {
            list = it
        }

        assertEquals(FakeDataSource.dailyAgendadlots.asDomainListAgendaslots(), list)
    }

    @Test
    fun apiAgendaslotRepository_getByRRN_verifyAgendaslotsList() = runBlocking {
        // Given: Insert fake Agendaslot items into the repository
//        val fakeAgendaslots = FakeDataSource.agendaslots.toList() // Create a defensive copy
//        fakeAgendaslots.forEach {
//            repository.insertAgendaslot(it)
//        }
//
//        // When: Retrieve Agendaslot items by RRN from the repository
//        var retrievedAgendaslots: List<Agendaslot> = emptyList()
//        val rrnToQuery = fakeAgendaslots.first().rijksregisternummer
//
//        repository.getByRRN(rrnToQuery).collect {
//            retrievedAgendaslots = it
//        }
//
//        // Then: Verify that the retrieved list matches the expected list
//        assertTrue("Retrieved list doesn't match the expected list",
//            retrievedAgendaslots == fakeAgendaslots.map { it.asDomainAgendaslot() }
//        )
    }
}