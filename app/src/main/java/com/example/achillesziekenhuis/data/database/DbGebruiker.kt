package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Gebruiker

@Entity(tableName = "gebruikers")
data class DbGebruiker (
    @PrimaryKey(autoGenerate = false)
    val rijksregisternummer: String = "",
    val voornaam: String = "",
    val familienaam: String = "",
    val geslacht: String = "",
    val geboortedatum: String = "",
    val geboorteplaats: String = "",
    val email: String = "",
    val telefoonnummer: String = "",
    val straat: String = "",
    val huisnummer: String = "",
    val optioneleAdreslijn: String = "",
    val postcode: String = "",
    val gemeente: String = "",
    val land: String = "",
    val auth0id: String = "",
)

fun DbGebruiker.asDomainGebruiker(): Gebruiker {
    return Gebruiker(
        this.rijksregisternummer,
        this.voornaam,
        this.familienaam,
        this.geslacht,
        this.geboortedatum,
        this.geboorteplaats,
        this.email,
        this.telefoonnummer,
        this.straat,
        this.huisnummer,
        this.optioneleAdreslijn,
        this.postcode,
        this.gemeente,
        this.land,
        this.auth0id,
    )
}

fun Gebruiker.asDbGebruiker(): DbGebruiker {
    return DbGebruiker(
        rijksregisternummer = this.rijksregisternummer,
        voornaam = this.voornaam,
        familienaam = this.familienaam,
        geslacht = this.geslacht,
        geboortedatum = this.geboortedatum,
        geboorteplaats = this.geboorteplaats,
        email = this.email,
        telefoonnummer = this.telefoonnummer,
        straat = this.straat,
        huisnummer = this.huisnummer,
        optioneleAdreslijn = this.optioneleAdreslijn,
        postcode = this.postcode,
        gemeente = this.gemeente,
        land = this.land,
        auth0id = this.auth0id,
    )
}

fun List<DbGebruiker>.asDomainGebruikers(): List<Gebruiker> {
    return this.map {
        it.asDomainGebruiker()
    }
}

