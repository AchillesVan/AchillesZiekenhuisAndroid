package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Gebruiker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

@Serializable
data class ApiGebruiker(
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
    val optionele_adreslijn: String = "",
    val postcode: String = "",
    val gemeente: String = "",
    val land: String = "",
    val auth0id: String = "",
)

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

fun Flow<ApiGebruiker>.asDomainListAgendaslot(): Flow<Gebruiker> {
    return this.map {
        it.asDomainListAgendaslot()
    }
}

fun List<ApiGebruiker>.asDomainAgendaslots(): List<Gebruiker> {
    var domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}

fun Flow<List<ApiGebruiker>>.asDomainAgendaslots(): Flow<List<Gebruiker>> {
    var domainList = this.map {
        it.asDomainAgendaslots()
    }
    return domainList
}