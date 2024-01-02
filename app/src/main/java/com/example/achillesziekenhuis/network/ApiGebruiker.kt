package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Gebruiker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

/**
 * Data class that represents a [Gebruiker] from the API.
 */
@Serializable
data class ApiGebruiker(
    /**
     * The National Insurance number (rijksregisternummer) of the patient.
     */
    val rijksregisternummer: String = "",
    /**
     * The first name of the patient.
     */
    val voornaam: String = "",
    /**
     * The last name of the patient.
     */
    val familienaam: String = "",
    /**
     * The gender of the patient.
     */
    val geslacht: String = "",
    /**
     * The date of birth of the patient.
     */
    val geboortedatum: String = "",
    /**
     * The place of birth of the patient.
     */
    val geboorteplaats: String = "",
    /**
     * The email address of the patient.
     */
    val email: String = "",
    /**
     * The phone number of the patient.
     */
    val telefoonnummer: String = "",
    /**
     * The street of the patient.
     */
    val straat: String = "",
    /**
     * The house number of the patient.
     */
    val huisnummer: String = "",
    /**
     * The optional address line of the patient.
     */
    val optionele_adreslijn: String = "",
    /**
     * The postal code of the patient.
     */
    val postcode: String = "",
    /**
     * The city of the patient.
     */
    val gemeente: String = "",
    /**
     * The country of the patient.
     */
    val land: String = "",
    /**
     * The auth0 id of the patient.
     */
    val auth0id: String = "",
)

/**
 * Extension function that converts an [ApiGebruiker] to a [Gebruiker].
 */
fun ApiGebruiker.asDomainListAgendaslot(): Gebruiker {
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
        this.optionele_adreslijn,
        this.postcode,
        this.gemeente,
        this.land,
        this.auth0id,
    )
}

/**
 * Extension function that converts a flow of an [ApiGebruiker] to a flow of a [Gebruiker].
 */
fun Flow<ApiGebruiker>.asDomainListAgendaslot(): Flow<Gebruiker> {
    return this.map {
        it.asDomainListAgendaslot()
    }
}

/**
 * Extension function that converts a list of [ApiGebruiker]s to a list of [Gebruiker]s.
 */
fun List<ApiGebruiker>.asDomainAgendaslots(): List<Gebruiker> {
    val domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}

/**
 * Extension function that converts a flow of a list of [ApiGebruiker]s to a flow of a list of [Gebruiker]s.
 */
fun Flow<List<ApiGebruiker>>.asDomainAgendaslots(): Flow<List<Gebruiker>> {
    val domainList = this.map {
        it.asDomainAgendaslots()
    }
    return domainList
}