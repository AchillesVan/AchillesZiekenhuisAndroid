package com.example.achillesziekenhuis.network

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * API communication interface for the [ApiAgendaslot] endpoints.
 */
interface AgendaslotApiService {

    /**
     * Returns a list of all available agendaslots per day.
     */
    @GET("agendaslots/daily")
    suspend fun getAgendaslotsDaily(): List<ApiListAgendaslot>

    /**
     * Returns a list of all agendaslots of a patient with a given National Insurance number (rijksregisternummer).
     */
    @GET("agendaslots/rrn/{rijksregisternummer}")
    suspend fun getAgendaslotsByRRN(@Path("rijksregisternummer") rijksregisternummer: String): List<ApiAgendaslot>

    /**
     * Returns a list of all agendaslots of a doctor with a given riziv number and date.
     */
    @GET("agendaslots/{date}/{riziv}")
    suspend fun getAgendaslotByRizivAndDate(@Path("date") date: String, @Path("riziv") riziv: String): List<ApiAgendaslot>

    /**
     * Inserts an agendaslot into the database.
     */
    @POST("agendaslots")
    suspend fun postAgendaslot(@Body agendaslot: ApiAgendaslot): Response<Unit>
}

/**
 * Extension function to get the agendaslots as a flow.
 */
fun AgendaslotApiService.getAgendaslotsDailyAsFlow(): Flow<List<ApiListAgendaslot>> = flow {
    emit(getAgendaslotsDaily())
}

/**
 * Extension function to get the agendaslots as a flow.
 */
fun AgendaslotApiService.getAgendaslotsByRRNAsFlow(rijksregisternummer: String): Flow<List<ApiAgendaslot>> = flow {
    emit(getAgendaslotsByRRN(rijksregisternummer))
}

/**
 * Extension function to get the agendaslots as a flow.
 */
fun AgendaslotApiService.getAgendaslotByRizivAndDateAsFlow(rizivNummer: String, date: String): Flow<List<ApiAgendaslot>> = flow {
    Log.d("AgendaslotApiService", "getAgendaslotByRizivAndDateAsFlow: $rizivNummer, $date")
    emit(getAgendaslotByRizivAndDate(rizivNummer, date))
}
