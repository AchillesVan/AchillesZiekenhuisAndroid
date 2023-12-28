package com.example.achillesziekenhuis.model

data class Gebruiker(
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