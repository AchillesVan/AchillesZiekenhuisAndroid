package com.example.achillesziekenhuis.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET

/**
 * API communication interface for the [ApiGebruiker] endpoints.
 */
interface GebruikerApiService {
    /**
     * Returns a list of all available gebruikers.
     */
    @GET("gebruikers")
    suspend fun getAllGebruikers(): List<ApiGebruiker>
}

/**
 * Extension function to get the gebruikers as a flow.
 */
fun GebruikerApiService.getGebruikersAsFlow(): Flow<List<ApiGebruiker>> = flow {
    emit(getAllGebruikers())
}