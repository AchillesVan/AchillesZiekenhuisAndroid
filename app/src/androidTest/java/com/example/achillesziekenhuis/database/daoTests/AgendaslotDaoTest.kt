package com.example.achillesziekenhuis.database.daoTests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.achillesziekenhuis.data.database.AgendaslotDao
import com.example.achillesziekenhuis.data.database.DbAgendaslot
import com.example.achillesziekenhuis.database.TestDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AgendaslotDaoTest {
    private lateinit var agendaslotDao: AgendaslotDao
    private lateinit var db: TestDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = TestDatabase.getDatabase(context)
        agendaslotDao = db.agendaslotDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() = runBlocking {
        val agendaslot = DbAgendaslot(
            id = 1,
            startTijd = "2023-12-30T10:00:00",
            eindTijd = "2023-12-30T10:00:00",
            rizivNummer = "12345678901",
            rijksregisternummer = "12345678901",
        )

        agendaslotDao.insert(agendaslot)

        var byRizivAndDate: DbAgendaslot? = null

        agendaslotDao.getItemByRizivAndDate(rizivNummer = agendaslot.rizivNummer, startTijd = agendaslot.startTijd).collect {
            byRizivAndDate = it[0]
        }

        assertEquals(byRizivAndDate, agendaslot)
    }

}