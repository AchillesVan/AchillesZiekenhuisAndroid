package com.example.achillesziekenhuis.network

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API communication interface for the [ApiDokter] endpoints.
 */
interface DokterApiService {
    /**
     * Returns a list of all available dokters.
     */
    @GET("dokters")
    suspend fun getDokters(): List<ApiDokter>

    /**
     * Returns a list of all available afdelingen.
     */
    @GET("dokters/afdelingen")
    suspend fun getAfdelingen(): List<String>

    /**
     * Returns a list of all available dokters of a given afdeling.
     */
    @GET("dokters/afdeling/{afdeling}")
    suspend fun getDoktersByAfdeling(@Path("afdeling") afdeling: String): List<ApiDokter>

    /**
     * Returns a dokter with a given riziv number.
     */
    @GET("dokters/riziv/{rizivNummer}")
    suspend fun getDokterByRiziv(@Path("rizivNummer") rizivNummer: String): ApiDokter
}

/**
 * Extension function to get the dokters as a flow.
 */
fun DokterApiService.getDoktersAsFlow(): Flow<List<ApiDokter>> = flow {
    emit(getDokters())
}

/**
 * Extension function to get the afdelingen as a flow.
 */
fun DokterApiService.getAfdelingenAsFlow(): Flow<List<String>> = flow {
    emit(getAfdelingen())
}

/**
 * Extension function to get the dokters as a flow.
 */
fun DokterApiService.getDoktersByAfdelingAsFlow(afdeling: String): Flow<List<ApiDokter>> = flow {
    emit(getDoktersByAfdeling(afdeling))
}

/**
 * Extension function to get the dokter as a flow.
 */
fun DokterApiService.getDokterByRizivAsFlow(rizivNummer: String): Flow<ApiDokter> = flow {
    Log.d("DokterApiService", "getDokterByRizivAsFlow: $rizivNummer")
    emit(getDokterByRiziv(rizivNummer))
}
