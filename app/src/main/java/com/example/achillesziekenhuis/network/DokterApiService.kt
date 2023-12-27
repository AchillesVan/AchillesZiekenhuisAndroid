package com.example.achillesziekenhuis.network

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

interface DokterApiService {
    @GET("dokters")
    suspend fun getDokters(): List<ApiDokter>

    @GET("dokters/afdelingen")
    suspend fun getAfdelingen(): List<String>

    @GET("dokters/afdeling/{afdeling}")
    suspend fun getDoktersByAfdeling(@Path("afdeling") afdeling: String): List<ApiDokter>

    @GET("dokters/riziv/{rizivNummer}")
    suspend fun getDokterByRiziv(@Path("rizivNummer") rizivNummer: String): ApiDokter
}

fun DokterApiService.getDoktersAsFlow(): Flow<List<ApiDokter>> = flow {
    emit(getDokters())
}

fun DokterApiService.getAfdelingenAsFlow(): Flow<List<String>> = flow {
    emit(getAfdelingen())
}

fun DokterApiService.getDoktersByAfdelingAsFlow(afdeling: String): Flow<List<ApiDokter>> = flow {
    emit(getDoktersByAfdeling(afdeling))
}

fun DokterApiService.getDokterByRizivAsFlow(rizivNummer: String): Flow<ApiDokter> = flow {
    Log.d("DokterApiService", "getDokterByRizivAsFlow: $rizivNummer")
    emit(getDokterByRiziv(rizivNummer))
}
