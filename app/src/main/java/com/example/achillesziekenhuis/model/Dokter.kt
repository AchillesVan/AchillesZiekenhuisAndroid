package com.example.achillesziekenhuis.model

data class Dokter(
    var rizivNummer: String,
    var voornaam: String,
    var familienaam: String,
    var afdeling: String = "",
    var telefoonnummer: String,
    var email: String,
) {
    override fun toString(): String {
        return "$voornaam $familienaam"
    }
}
