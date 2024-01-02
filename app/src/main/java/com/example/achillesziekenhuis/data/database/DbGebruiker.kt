package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Gebruiker

/**
 * Database entities go in this file. These are responsible for reading and writing from the
 * database.
 */
@Entity(tableName = "gebruikers")
data class DbGebruiker (
    /**
     * This is the National Insurance number (rijksregisternummer) of the patient.
     */
    @PrimaryKey(autoGenerate = false)
    val rijksregisternummer: String = "",
    /**
     * This is the first name of the patient.
     */
    val voornaam: String = "",
    /**
     * This is the last name of the patient.
     */
    val familienaam: String = "",
    /**
     * This is the gender of the patient.
     */
    val geslacht: String = "",
    /**
     * This is the birth date of the patient.
     */
    val geboortedatum: String = "",
    /**
     * This is the birth place of the patient.
     */
    val geboorteplaats: String = "",
    /**
     * This is the email of the patient.
     */
    val email: String = "",
    /**
     * This is the phone number of the patient.
     */
    val telefoonnummer: String = "",
    /**
     * This is the street of the patient.
     */
    val straat: String = "",
    /**
     * This is the house number of the patient.
     */
    val huisnummer: String = "",
    /**
     * This is the optional address line of the patient.
     */
    val optioneleAdreslijn: String = "",
    /**
     * This is the postal code of the patient.
     */
    val postcode: String = "",
    /**
     * This is the city of the patient.
     */
    val gemeente: String = "",
    /**
     * This is the country of the patient.
     */
    val land: String = "",
    /**
     * This is the auth0 id of the patient.
     */
    val auth0id: String = "",
)

/**
 * Map database entity [DbGebruiker] to domain entity [Gebruiker]
 */
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

/**
 * Map domain entity [Gebruiker] to database entity [DbGebruiker]
 */
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

/**
 * Map a list of database entities [DbGebruiker] to domain entities [Gebruiker]
 */
fun List<DbGebruiker>.asDomainGebruikers(): List<Gebruiker> {
    return this.map {
        it.asDomainGebruiker()
    }
}

