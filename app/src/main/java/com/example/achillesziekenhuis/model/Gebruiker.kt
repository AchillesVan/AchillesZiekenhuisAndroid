package com.example.achillesziekenhuis.model

/**
 * Data class that represents a user.
 */
data class Gebruiker(
    /**
     * The National Insurance number (rijksregisternummer) of the user.
     */
    val rijksregisternummer: String = "",
    /**
     * The first name of the user.
     */
    val voornaam: String = "",
    /**
     * The last name of the user.
     */
    val familienaam: String = "",
    /**
     * The gender of the user.
     */
    val geslacht: String = "",
    /**
     * The date of birth of the user.
     */
    val geboortedatum: String = "",
    /**
     * The place of birth of the user.
     */
    val geboorteplaats: String = "",
    /**
     * The email address of the user.
     */
    val email: String = "",
    /**
     * The phone number of the user.
     */
    val telefoonnummer: String = "",
    /**
     * The street of the user.
     */
    val straat: String = "",
    /**
     * The house number of the user.
     */
    val huisnummer: String = "",
    /**
     * The optional address line of the user.
     */
    val optioneleAdreslijn: String = "",
    /**
     * The postal code of the user.
     */
    val postcode: String = "",
    /**
     * The city of the user.
     */
    val gemeente: String = "",
    /**
     * The country of the user.
     */
    val land: String = "",
    /**
     * The Auth0 ID of the user.
     */
    val auth0id: String = "",
)