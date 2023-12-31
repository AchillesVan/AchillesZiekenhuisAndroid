package com.example.achillesziekenhuis.data.network

import com.example.achillesziekenhuis.network.ApiAgendaslot
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class ApiAgendaslotTest {

    private val rizivValid = "12244933822"
    private val rizivTooShort = "123"
    private val rizivTooLong = "123456789123"
    private val rizivInvalidChars = "123abc456de"

    private val rrnValid = "00.12.01-197.80"
    private val rrnTooShort = "00.12"
    private val rrnTooLong = "00.12.01-197.80.70"
    private val rrnInvalidChars = "ab.12.01-197.80"

    private val datumValid = LocalDate.now().plusDays(1).toString()
    private val datumTooSoon = LocalDate.now().minusDays(1).toString()
    private val datumEmpty = "Selecteer datum"

    private val startTijdValid = "09:00:00"
    private val startTijdEmpty = "-- Selecteer tijdstip --"
    private val startTijdTooEarly = "08:30:00"
    private val startTijdTooLate = "17:30:00"

    @Test
    fun ApiAgendaslot_Creation_Success() {
        assertTrue(ApiAgendaslot.create(rizivValid, rrnValid, datumValid, startTijdValid) is ApiAgendaslot)
    }

    @Test
    fun ApiAgendaslot_Creation_RizivTooShort() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivTooShort, rrnValid, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_RizivTooLong() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivTooLong, rrnValid, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_RizivInvalidChars() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivInvalidChars, rrnValid, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_RrnTooShort() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnTooShort, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_RrnTooLong() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnTooLong, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_RrnInvalidChars() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnInvalidChars, datumValid, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_DatumTooSoon() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnValid, datumTooSoon, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_DatumEmpty() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnValid, datumEmpty, startTijdValid)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_StartTijdEmpty() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnValid, datumValid, startTijdEmpty)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_StartTijdTooEarly() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnValid, datumValid, startTijdTooEarly)
        }
    }

    @Test
    fun ApiAgendaslot_Creation_StartTijdTooLate() {
        assertThrows(IllegalArgumentException::class.java) {
            ApiAgendaslot.create(rizivValid, rrnValid, datumValid, startTijdTooLate)
        }
    }
}