package com.example.achillesziekenhuis.fake

import com.example.achillesziekenhuis.model.ListAgendaslot
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.network.ApiDokter
import com.example.achillesziekenhuis.network.ApiListAgendaslot

object FakeDataSource {
    val dokter1 = ApiDokter(
        riziv_nummer = "12244933822",
        voornaam = "Jan",
        familienaam = "Janssens",
        afdeling = "Cardiologie",
        telefoonnummer = "+32002892286",
        email = "jan.janssens@achillesziekenhuis.be",
    )

    val dokter2 = ApiDokter(
        riziv_nummer = "24477043644",
        voornaam = "Bert",
        familienaam = "Bertens",
        afdeling = "Nefrologie",
        telefoonnummer = "+32125916382",
        email = "bert.bertens@achillesziekenhuis.be",
    )

    val dokters = mutableListOf(
        dokter1,
        dokter2,
    )

    val agendaslot1= ApiAgendaslot(
        id = 1,
        riziv_nummer = "12244933822",
        rijksregisternummer = "00.12.01-197.80",
        start_tijd = "2021-05-01T08:00:00.000Z",
        eind_tijd = "2021-05-01T08:30:00.000Z",
    )

    val agendaslot2= ApiAgendaslot(
        id = 1,
        riziv_nummer = "12244933822",
        rijksregisternummer = "00.12.01-197.80",
        start_tijd = "2022-10-13T11:30:00.000Z",
        eind_tijd = "2022-10-13T12:00:00.000Z",
    )

    val agendaslots = mutableListOf(
        agendaslot1,
        agendaslot2,
    )

    val dailyAgendadlots = listOf(
        ApiListAgendaslot(value = "09:00:00", label = "09:00:00"),
        ApiListAgendaslot(value = "09:30:00", label = "09:30:00"),
        ApiListAgendaslot(value = "10:00:00", label = "10:00:00"),
        ApiListAgendaslot(value = "10:30:00", label = "10:30:00"),
        ApiListAgendaslot(value = "11:00:00", label = "11:00:00"),
        ApiListAgendaslot(value = "11:30:00", label = "11:30:00"),
        ApiListAgendaslot(value = "12:00:00", label = "12:00:00"),
        ApiListAgendaslot(value = "12:30:00", label = "12:30:00"),
        ApiListAgendaslot(value = "13:00:00", label = "13:00:00"),
        ApiListAgendaslot(value = "13:30:00", label = "13:30:00"),
        ApiListAgendaslot(value = "14:00:00", label = "14:00:00"),
        ApiListAgendaslot(value = "14:30:00", label = "14:30:00"),
        ApiListAgendaslot(value = "15:00:00", label = "15:00:00"),
        ApiListAgendaslot(value = "15:30:00", label = "15:30:00"),
        ApiListAgendaslot(value = "16:00:00", label = "16:00:00"),
        ApiListAgendaslot(value = "16:30:00", label = "16:30:00"),
        ApiListAgendaslot(value = "17:00:00", label = "17:00:00"),

    )
}