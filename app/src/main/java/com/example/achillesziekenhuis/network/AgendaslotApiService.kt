package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Agendaslot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AgendaslotApiService {

    @GET("agendaslots/daily")
    suspend fun getAgendaslotsDaily(): List<ApiListAgendaslot>

    @GET("agendaslots/rrn/{rijksregisternummer}")
    suspend fun getAgendaslotsByRRN(@Path("rijksregisternummer") rijksregisternummer: String): List<ApiAgendaslot>

    @GET("agendaslots/{date}/{rizivNummer}")
    suspend fun getAgendaslotByRizivAndDate(@Path("rizivNummer") rizivNummer: String, @Path("date") date: String): List<ApiAgendaslot>

    @POST("agendaslots")
    suspend fun postAgendaslot(agendaslot: Agendaslot)
}

fun AgendaslotApiService.getAgendaslotsDailyAsFlow(): Flow<List<ApiListAgendaslot>> = flow {
    emit(getAgendaslotsDaily())
}

fun AgendaslotApiService.getAgendaslotsByRRNAsFlow(rijksregisternummer: String): Flow<List<ApiAgendaslot>> = flow {
    emit(getAgendaslotsByRRN(rijksregisternummer))
}

fun AgendaslotApiService.getAgendaslotByRizivAndDateAsFlow(rizivNummer: String, date: String): Flow<List<ApiAgendaslot>> = flow {
    emit(getAgendaslotByRizivAndDate(rizivNummer, date))
}
