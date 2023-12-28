package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GebruikerDao {

    @Query("SELECT * FROM gebruikers")
    fun getAllGebruikers(): Flow<List<DbGebruiker>>

    @Query("SELECT * FROM gebruikers WHERE auth0id = :auth0id")
    fun getGebruikerByAuth0id(auth0id: String): Flow<DbGebruiker>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DbGebruiker)
}