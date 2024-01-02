package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for [DbAgendaslot] table.
 */
@Dao
interface AgendaslotDao {
    /**
     * Insert a [DbAgendaslot] into the [DbAgendaslot] table.
     */
    @Insert
    suspend fun insert(item: DbAgendaslot)

    /**
     * Update a [DbAgendaslot] in the [DbAgendaslot] table.
     */
    @Update
    suspend fun update(item: DbDokter)

    /**
     * Delete a [DbAgendaslot] from the [DbAgendaslot] table.
     */
    @Delete
    suspend fun delete(item: DbDokter)

    /**
     * Get all the [DbAgendaslot] with a specific National Insurance number from the [DbAgendaslot] table.
     */
    @Query("SELECT * from agendaslots WHERE rijksregisternummer = :rijksregisternummer")
    fun getItemByRRN(rijksregisternummer: String): Flow<List<DbAgendaslot>>

    /**
     * Get all the [DbAgendaslot] with a specific riziv number and start time from the [DbAgendaslot] table.
     */
    @Query("SELECT * from agendaslots WHERE rizivNummer = :rizivNummer AND startTijd = :startTijd")
    fun getItemByRizivAndDate(rizivNummer: String, startTijd: String): Flow<List<DbAgendaslot>>
}
