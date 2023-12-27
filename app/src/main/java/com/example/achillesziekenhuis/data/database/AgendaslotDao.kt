package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface AgendaslotDao {
    @Insert
    suspend fun insert(item: DbAgendaslot)

    @Update
    suspend fun update(item: DbDokter)

    @Delete
    suspend fun delete(item: DbDokter)

    @Query("SELECT * from agendaslots WHERE rijksregisternummer = :rijksregisternummer")
    fun getItemByRRN(rijksregisternummer: String): Flow<List<DbAgendaslot>>

    @Query("SELECT * from agendaslots WHERE rizivNummer = :rizivNummer AND startTijd = :startTijd")
    fun getItemByRizivAndDate(rizivNummer: String, startTijd: String): Flow<List<DbAgendaslot>>
}
