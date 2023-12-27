package com.example.achillesziekenhuis.data.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.Executors

@Database(entities = [DbDokter::class, DbAgendaslot::class], version = 1, exportSchema = false)
abstract class DokterDb : RoomDatabase() {

    abstract fun dokterDao(): DokterDao

    abstract fun agendaslotDao(): AgendaslotDao

    companion object {
        @Volatile
        private var Instance: DokterDb? = null

        fun getDatabase(context: Context): DokterDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DokterDb::class.java, "dokter_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
