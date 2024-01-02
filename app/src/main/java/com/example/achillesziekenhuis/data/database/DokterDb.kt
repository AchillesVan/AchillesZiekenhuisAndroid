package com.example.achillesziekenhuis.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database for storing [DbDokter], [DbAgendaslot] and [DbGebruiker] entities.
 */
@Database(entities = [DbDokter::class, DbAgendaslot::class, DbGebruiker::class], version = 2, exportSchema = false)
abstract class DokterDb : RoomDatabase() {

    /**
     * Returns a Data Access Object for the [DbDokter] table.
     */
    abstract fun dokterDao(): DokterDao

    /**
     * Returns a Data Access Object for the [DbAgendaslot] table.
     */
    abstract fun agendaslotDao(): AgendaslotDao

    /**
     * Returns a Data Access Object for the [DbGebruiker] table.
     */
    abstract fun gebruikerDao(): GebruikerDao

    companion object {
        @Volatile
        private var Instance: DokterDb? = null

        /**
         * Returns a singleton instance of the database.
         */
        fun getDatabase(context: Context): DokterDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DokterDb::class.java, "dokter_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
