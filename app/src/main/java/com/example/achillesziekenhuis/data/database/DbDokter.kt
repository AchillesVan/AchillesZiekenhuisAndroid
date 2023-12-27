package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Dokter

@Entity(tableName = "dokters")
data class DbDokter(
    @PrimaryKey(autoGenerate = false)
    val rizivNummer: String = "",
    val voornaam: String = "",
    val familienaam: String = "",
    val afdeling: String = "",
    val telefoonnummer: String = "",
    val email: String = "",
)

fun DbDokter.asDomainDokter(): Dokter {
    return Dokter(
        this.rizivNummer,
        this.voornaam,
        this.familienaam,
        this.afdeling,
        this.telefoonnummer,
        this.email,
    )
}

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

fun List<DbDokter>.asDomainDokters(): List<Dokter> {
    val dokterList = this.map {
        Dokter(it.rizivNummer, it.voornaam, it.familienaam, it.afdeling, it.telefoonnummer, it.email)
    }
    return dokterList
}
