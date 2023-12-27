package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DokterDao {

    @Query("SELECT * FROM dokters ORDER BY familienaam ASC")
    fun getAllDokters(): Flow<List<DbDokter>>

    @Query("SELECT DISTINCT afdeling FROM dokters ORDER BY afdeling ASC")
    fun getAfdelingen(): Flow<List<String>>

    @Query("SELECT * FROM dokters WHERE afdeling = :afdeling")
    fun getDoktersByAfdeling(afdeling: String): Flow<List<DbDokter>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DbDokter)

    @Update
    suspend fun update(item: DbDokter)

    @Delete
    suspend fun delete(item: DbDokter)
}
