package com.example.achillesziekenhuis.fake

import androidx.work.WorkInfo
import com.example.achillesziekenhuis.data.DoktersRepository
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.network.asApiDokter
import com.example.achillesziekenhuis.network.asDomainDokters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Fake implementation of [DoktersRepository] for testing.
 */
class FakeApiDokterRepository : DoktersRepository {
    override fun getDokters(): Flow<List<Dokter>> = flow {
        emit(FakeDataSource.dokters.asDomainDokters())
    }

    override fun getAfdelingen(): Flow<List<String>> = flow {
        emit(FakeDataSource.dokters.map { it.afdeling }.distinct())
    }

    override fun getDoktersByAfdeling(afdeling: String): Flow<List<Dokter>> = flow {
        emit(FakeDataSource.dokters.filter { it.afdeling == afdeling }.asDomainDokters())
    }

    override suspend fun insertDokter(dokter: Dokter) {
        FakeDataSource.dokters.add(dokter.asApiDokter())
    }

    override suspend fun updateDokter(dokter: Dokter) {
        if(!FakeDataSource.dokters.any { it.riziv_nummer == dokter.rizivNummer }) {
            FakeDataSource.dokters.removeIf { it.riziv_nummer == dokter.rizivNummer }
            FakeDataSource.dokters.add(dokter.asApiDokter())
        }
    }

    override suspend fun deleteDokter(dokter: Dokter) {
        FakeDataSource.dokters.remove(dokter.asApiDokter())
    }

    override suspend fun refresh() {
        TODO("Not yet implemented")
    }

    override var wifiWorkInfo: Flow<WorkInfo>
        get() = TODO("Not yet implemented")
        set(value) {}
}