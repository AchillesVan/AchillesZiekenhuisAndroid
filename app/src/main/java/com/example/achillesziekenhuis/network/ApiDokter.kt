package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Dokter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

@Serializable
data class ApiDokter(
    var riziv_nummer: String,
    var voornaam: String,
    var familienaam: String,
    var afdeling: String = "",
    var telefoonnummer: String,
    var email: String,
)

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

fun Flow<ApiDokter>.asDomainListAgendaslot(): Flow<Dokter> {
    return this.map {
        it.asDomainListAgendaslot()
    }
}

fun List<ApiDokter>.asDomainAgendaslots(): List<Dokter> {
    var domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}

fun Flow<List<ApiDokter>>.asDomainAgendaslots(): Flow<List<Dokter>> {
    var domainList = this.map {
        it.asDomainAgendaslots()
    }
    return domainList
}
