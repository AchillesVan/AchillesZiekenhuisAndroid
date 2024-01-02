package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Dokter

/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */
@Entity(tableName = "dokters")
data class DbDokter(
    /**
     * This is the riziv number of the doctor.
     */
    @PrimaryKey(autoGenerate = false)
    val rizivNummer: String = "",
    /**
     * This is the first name of the doctor.
     */
    val voornaam: String = "",
    /**
     * This is the last name of the doctor.
     */
    val familienaam: String = "",
    /**
     * This is the department of the doctor.
     */
    val afdeling: String = "",
    /**
     * This is the phone number of the doctor.
     */
    val telefoonnummer: String = "",
    /**
     * This is the email of the doctor.
     */
    val email: String = "",
)

//fun DbDokter.asDomainDokter(): Dokter {
//    return Dokter(
//        this.rizivNummer,
//        this.voornaam,
//        this.familienaam,
//        this.afdeling,
//        this.telefoonnummer,
//        this.email,
//    )
//}

/**
 * Map domain entity [Dokter] to database entity [DbDokter]
 */
fun Dokter.asDbDokter(): DbDokter {
    return DbDokter(
        rizivNummer = this.rizivNummer,
        voornaam = this.voornaam,
        familienaam = this.familienaam,
        afdeling = this.afdeling,
        telefoonnummer = this.telefoonnummer,
        email = this.email,
    )
}

/**
 * Map a list of database entities[DbDokter] to domain entities [Dokter]
 */
fun List<DbDokter>.asDomainDokters(): List<Dokter> {
    val dokterList = this.map {
        Dokter(it.rizivNummer, it.voornaam, it.familienaam, it.afdeling, it.telefoonnummer, it.email)
    }
    return dokterList
}
