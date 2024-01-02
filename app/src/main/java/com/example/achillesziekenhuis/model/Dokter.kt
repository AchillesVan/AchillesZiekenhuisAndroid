package com.example.achillesziekenhuis.model

/**
 * Data class that represents a dokter.
 */
data class Dokter(
    /**
     * The riziv number of the dokter.
     */
    var rizivNummer: String,
    /**
     * The first name of the dokter.
     */
    var voornaam: String,
    /**
     * The last name of the dokter.
     */
    var familienaam: String,
    /**
     * The department of the dokter.
     */
    var afdeling: String = "",
    /**
     * The phone number of the dokter.
     */
    var telefoonnummer: String,
    /**
     * The email address of the dokter.
     */
    var email: String,
) {
    override fun toString(): String {
        return "$voornaam $familienaam"
    }
}
