package com.example.achillesziekenhuis.fake

import com.example.achillesziekenhuis.network.ApiDokter
import com.example.achillesziekenhuis.network.DokterApiService

/**
 * Fake implementation of [DokterApiService] for testing.
 */
class FakeApiDoktersService: DokterApiService {
    /**
     * Returns a list of all available dokters.
     */
    override suspend fun getDokters(): List<ApiDokter> {
        return FakeDataSource.dokters
    }

    /**
     * Returns a list of all available afdelingen.
     */
    override suspend fun getAfdelingen(): List<String> {
        return FakeDataSource.dokters.map { it.afdeling }.distinct()
    }

    /**
     * Returns a list of all dokters of a specific afdeling.
     */
    override suspend fun getDoktersByAfdeling(afdeling: String): List<ApiDokter> {
        return FakeDataSource.dokters.filter { it.afdeling == afdeling }
    }

    /**
     * Returns a dokter with a given riziv number.
     */
    override suspend fun getDokterByRiziv(rizivNummer: String): ApiDokter {
        return FakeDataSource.dokters.first { it.riziv_nummer == rizivNummer }
    }
}