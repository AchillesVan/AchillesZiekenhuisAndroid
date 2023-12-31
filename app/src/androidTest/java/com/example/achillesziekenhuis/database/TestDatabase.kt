package com.example.achillesziekenhuis.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.achillesziekenhuis.data.database.AgendaslotDao
import com.example.achillesziekenhuis.data.database.DbAgendaslot
import com.example.achillesziekenhuis.data.database.DbDokter
import com.example.achillesziekenhuis.data.database.DbGebruiker
import com.example.achillesziekenhuis.data.database.DokterDao
import com.example.achillesziekenhuis.data.database.GebruikerDao

@Database(entities = [DbAgendaslot::class, DbGebruiker::class, DbDokter::class], version = 1, exportSchema = false)
abstract class TestDatabase : RoomDatabase() {

    abstract fun dokterDao(): DokterDao

    abstract fun agendaslotDao(): AgendaslotDao

    abstract fun gebruikerDao(): GebruikerDao

    companion object {
        @Volatile
        private var Instance: TestDatabase? = null

        fun getDatabase(context: Context): TestDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.inMemoryDatabaseBuilder(context, TestDatabase::class.java)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}