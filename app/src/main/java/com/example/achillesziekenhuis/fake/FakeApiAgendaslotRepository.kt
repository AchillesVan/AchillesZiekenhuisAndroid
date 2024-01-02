package com.example.achillesziekenhuis.fake

import androidx.work.WorkInfo
import com.example.achillesziekenhuis.data.AgendaslotRepository
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.ListAgendaslot
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.network.asDomainAgendaslots
import com.example.achillesziekenhuis.network.asDomainListAgendaslots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

/**
 * Fake implementation of [AgendaslotRepository] for testing.
 */
class FakeApiAgendaslotRepository: AgendaslotRepository {
    override fun getDailyAgendaslots(): Flow<List<ListAgendaslot>> = flow {
        emit(FakeDataSource.dailyAgendadlots.asDomainListAgendaslots())
    }

    override fun getByRRN(rijksregisternummer: String): Flow<List<Agendaslot>> = flow {
        emit(FakeDataSource.agendaslots.filter { it.rijksregisternummer == rijksregisternummer }.asDomainAgendaslots())
    }

    override fun getByRizivAndDate(date: String, rizivNummer: String): Flow<List<Agendaslot>> = flow {
            emit(FakeDataSource.agendaslots.filter { LocalDate.parse(it.eind_tijd).toString() == date && it.riziv_nummer == rizivNummer }.asDomainAgendaslots())
    }

    override suspend fun insertAgendaslot(agendaslot: ApiAgendaslot) {
        FakeDataSource.agendaslots.add(agendaslot)
    }

    override var wifiWorkInfo: Flow<WorkInfo>
        get() = TODO("Not yet implemented")
        set(value) {}
}