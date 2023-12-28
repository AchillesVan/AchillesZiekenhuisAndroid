package com.example.achillesziekenhuis.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET

interface GebruikerApiService {
    @GET("gebruikers")
    suspend fun getAllGebruikers(): List<ApiGebruiker>
}

fun GebruikerApiService.getGebruikersAsFlow(): Flow<List<ApiGebruiker>> = flow {
    emit(getAllGebruikers())
}