package com.example.achillesziekenhuis.fake

import com.example.achillesziekenhuis.network.ApiDokter
import com.example.achillesziekenhuis.network.DokterApiService

class FakeApiDoktersService: DokterApiService {
    override suspend fun getDokters(): List<ApiDokter> {
        return FakeDataSource.dokters
    }

    override suspend fun getAfdelingen(): List<String> {
        return FakeDataSource.dokters.map { it.afdeling }.distinct()
    }

    override suspend fun getDoktersByAfdeling(afdeling: String): List<ApiDokter> {
        return FakeDataSource.dokters.filter { it.afdeling == afdeling }
    }

    override suspend fun getDokterByRiziv(rizivNummer: String): ApiDokter {
        return FakeDataSource.dokters.first { it.riziv_nummer == rizivNummer }
    }
}