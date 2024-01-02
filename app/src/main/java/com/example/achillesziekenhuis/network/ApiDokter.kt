package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Dokter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

/**
 * Data class that represents a [Dokter] from the API.
 */
@Serializable
data class ApiDokter(
    /**
     * The riziv number of the dokter.
     */
    var riziv_nummer: String,
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
)

/**
 * Extension function that converts a [Dokter] to an [ApiDokter].
 */
fun Dokter.asApiDokter(): ApiDokter {
    return ApiDokter(
        this.rizivNummer,
        this.voornaam,
        this.familienaam,
        this.afdeling,
        this.telefoonnummer,
        this.email,
    )
}

/**
 * Extension function that converts an [ApiDokter] to a [Dokter].
 */
fun ApiDokter.asDomainListAgendaslot(): Dokter {
    return Dokter(
        this.riziv_nummer,
        this.voornaam,
        this.familienaam,
        this.afdeling,
        this.telefoonnummer,
        this.email,
    )
}

/**
 * Extension function that converts a flow of an [ApiDokter] to a flow of a [Dokter].
 */
fun Flow<ApiDokter>.asDomainDokter(): Flow<Dokter> {
    return this.map {
        it.asDomainListAgendaslot()
    }
}

/**
 * Extension function that converts a list of [ApiDokter]s to a list of [Dokter]s.
 */
fun List<ApiDokter>.asDomainDokters(): List<Dokter> {
    val domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}

/**
 * Extension function that converts a flow of a list of [ApiDokter]s to a flow of a list of [Dokter]s.
 */
fun Flow<List<ApiDokter>>.asDomainDomaindokters(): Flow<List<Dokter>> {
    val domainList = this.map {
        it.asDomainDokters()
    }
    return domainList
}
