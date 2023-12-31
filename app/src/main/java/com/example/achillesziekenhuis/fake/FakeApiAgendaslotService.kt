package com.example.achillesziekenhuis.fake

import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.network.ApiListAgendaslot
import retrofit2.Response
import java.time.LocalDate

class FakeApiAgendaslotService: AgendaslotApiService {
    override suspend fun getAgendaslotsDaily(): List<ApiListAgendaslot> {
        return FakeDataSource.dailyAgendadlots
    }

    override suspend fun getAgendaslotsByRRN(rijksregisternummer: String): List<ApiAgendaslot> {
        return FakeDataSource.agendaslots.filter { it.rijksregisternummer == rijksregisternummer }
    }

    override suspend fun getAgendaslotByRizivAndDate(
        date: String,
        riziv: String
    ): List<ApiAgendaslot> {
        return FakeDataSource.agendaslots.filter { LocalDate.parse(it.eind_tijd).toString() == date && it.riziv_nummer == riziv }
    }

    override suspend fun postAgendaslot(agendaslot: ApiAgendaslot): Response<Unit> {
        FakeDataSource.agendaslots.add(agendaslot)
        return Response.success(Unit)
    }
}