package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Agendaslot
import java.time.LocalDateTime

/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */
@Entity(tableName = "agendaslots")
data class DbAgendaslot(
    /**
     * This is an auto generated id for the agenda slot.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    /**
     * This is the riziv number of the doctor.
     */
    val rizivNummer: String = "",
    /**
     * This is the National Insurance number (rijksregisternummer) of the patient.
     */
    val rijksregisternummer: String = "",
    /**
     * This is the start time of the agenda slot.
     */
    val startTijd: String = "",
    /**
     * This is the end time of the agenda slot.
     */
    val eindTijd: String = "",
)

/**
 * Map [DbAgendaslot] to domain entity [Agendaslot]
 */
fun DbAgendaslot.asDomainAgendaslot(): Agendaslot {
    return Agendaslot(
        this.id,
        this.rizivNummer,
        this.rijksregisternummer,
        LocalDateTime.parse(this.startTijd),
    )
}

/**
 * Map domain entity [Agendaslot] to database entities [DbAgendaslot]
 */
fun Agendaslot.asDbAgendaslot(): DbAgendaslot {
    return DbAgendaslot(
        id = this.id,
        rizivNummer = this.rizivNummer,
        rijksregisternummer = this.rijksregisternummer,
        startTijd = this.startTijd.toString(),
    )
}

/**
 * Map a list of database entities [DbAgendaslot] to domain entities [Agendaslot]
 */
fun List<DbAgendaslot>.asDomainAgendaslots(): List<Agendaslot> {
    val agendaslotList = this.map {
        Agendaslot(
            it.id,
            it.rizivNummer,
            it.rijksregisternummer,
            LocalDateTime.parse(it.startTijd),
        )
    }
    return agendaslotList
}


