package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */
@Dao
interface GebruikerDao {

    /**
     * Select all gebruikers from the gebruikers table.
     */
    @Query("SELECT * FROM gebruikers")
    fun getAllGebruikers(): Flow<List<DbGebruiker>>

    /**
     * Select a gebruiker by their auth0id.
     */
    @Query("SELECT * FROM gebruikers WHERE auth0id = :auth0id")
    fun getGebruikerByAuth0id(auth0id: String): Flow<DbGebruiker>

    /**
     * Insert a gebruiker in the database. If the gebruiker already exists, ignore it.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DbGebruiker)
}