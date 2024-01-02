package com.example.achillesziekenhuis.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */
@Dao
interface DokterDao {

    /**
     * Select all dokters from the dokters table ordered by their last name.
     */
    @Query("SELECT * FROM dokters ORDER BY familienaam ASC")
    fun getAllDokters(): Flow<List<DbDokter>>

    /**
     * Select the distinct departments of all doctors
     */
    @Query("SELECT DISTINCT afdeling FROM dokters ORDER BY afdeling ASC")
    fun getAfdelingen(): Flow<List<String>>

    /**
     * Select all doctors from a specific department
     */
    @Query("SELECT * FROM dokters WHERE afdeling = :afdeling")
    fun getDoktersByAfdeling(afdeling: String): Flow<List<DbDokter>>

    /**
     * Insert a dokter in the database. If the dokter already exists, ignore it.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DbDokter)

    /**
     * Update a dokter.
     */
    @Update
    suspend fun update(item: DbDokter)

    /**
     * Delete a dokter.
     */
    @Delete
    suspend fun delete(item: DbDokter)
}
