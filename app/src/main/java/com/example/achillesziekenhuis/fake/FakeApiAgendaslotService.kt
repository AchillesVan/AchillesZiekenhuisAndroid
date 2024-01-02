package com.example.achillesziekenhuis.fake

import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.network.ApiListAgendaslot
import retrofit2.Response
import java.time.LocalDate

/**
 * Fake implementation of [AgendaslotApiService] for testing.
 */
class FakeApiAgendaslotService: AgendaslotApiService {
    /**
     * Returns a list of all available agendaslots per day.
     */
    override suspend fun getAgendaslotsDaily(): List<ApiListAgendaslot> {
        return FakeDataSource.dailyAgendadlots
    }

    /**
     * Returns a list of all agendaslots of a patient with a given National Insurance number (rijksregisternummer).
     */
    override suspend fun getAgendaslotsByRRN(rijksregisternummer: String): List<ApiAgendaslot> {
        return FakeDataSource.agendaslots.filter { it.rijksregisternummer == rijksregisternummer }
    }

    /**
     * Returns a list of all agendaslots of a doctor with a given riziv number and date.
     */
    override suspend fun getAgendaslotByRizivAndDate(
        date: String,
        riziv: String
    ): List<ApiAgendaslot> {
        return FakeDataSource.agendaslots.filter { LocalDate.parse(it.eind_tijd).toString() == date && it.riziv_nummer == riziv }
    }

    /**
     * Inserts an agendaslot into the database.
     */
    override suspend fun postAgendaslot(agendaslot: ApiAgendaslot): Response<Unit> {
        FakeDataSource.agendaslots.add(agendaslot)
        return Response.success(Unit)
    }
}