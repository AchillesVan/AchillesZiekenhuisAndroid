package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Agendaslot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Data class that represents an [Agendaslot] from the API.
 */
@Serializable
data class ApiAgendaslot(
    /**
     * Unique identifier for the agendaslot.
     */
    var id: Int = 0,
    /**
     * The riziv number of the doctor.
     */
    var riziv_nummer: String = "",
    /**
     * The National Insurance number (rijksregisternummer) of the patient.
     */
    var rijksregisternummer: String = "",
    /**
     * The start time of the agendaslot.
     */
    var start_tijd: String = "",
    /**
     * The end time of the agendaslot.
     */
    var eind_tijd: String = "",
) {
    companion object {
        /**
         * Creates an [ApiAgendaslot] from a given riziv number, National Insurance number (rijksregisternummer), date and start time.
         */
        fun create(
            rizivNummer: String,
            rijksregisternummer: String,
            datum: String,
            startTijd: String,
        ): ApiAgendaslot {
            if (rizivNummer.any { !it.isDigit() } || (rizivNummer.filter { it.isDigit() }.length != 11)) {
                throw IllegalArgumentException("Ongeldig Rizivnummer.")
            } else if (rijksregisternummer.filter { it.isDigit() }.length != 11 || rijksregisternummer.any { it !in ".-0123456789" }) {
                throw IllegalArgumentException("Ongeldig Rijksregisternummer.")
            } else if (datum == "Selecteer datum") {
                throw IllegalArgumentException("Geef een datum in.")
            } else if (LocalDate.parse(datum).isBefore(LocalDate.now())) {
                throw IllegalArgumentException("Ongeldige datum.")
            } else if (startTijd.length != 8
                || LocalTime.parse(startTijd).isBefore(LocalTime.parse("09:00:00"))
                || LocalTime.parse(startTijd).isAfter(LocalTime.parse("17:00:00"))
            ) {
                throw IllegalArgumentException("Ongeldige starttijd.")
            } else {
                return ApiAgendaslot(
                    0,
                    rizivNummer,
                    rijksregisternummer,
                    "${datum}T${LocalTime.parse(startTijd).plusMinutes(60)}",
                    "${datum}T${LocalTime.parse(startTijd).plusMinutes(90)}",
                )
            }
        }
    }
}

/**
 * Represents an [ApiAgendaslot] as an [Agendaslot].
 */
fun ApiAgendaslot.asDomainAgendaslot(): Agendaslot {
    return Agendaslot(
        this.id,
        this.riziv_nummer,
        this.rijksregisternummer,
        LocalDateTime.parse(this.start_tijd),
    )
}

/**
 * Represents a list of [ApiAgendaslot]s as a list of [Agendaslot]s.
 */
fun List<ApiAgendaslot>.asDomainAgendaslots(): List<Agendaslot> {
    val domainList = this.map {
        it.asDomainAgendaslot()
    }
    return domainList
}

/**
 * Represents a flow of a list of [ApiAgendaslot]s as a flow of a list of [Agendaslot]s.
 */
fun Flow<List<ApiAgendaslot>>.asDomainAgendaslots(): Flow<List<Agendaslot>> {
    val domainList = this.map {
        it.asDomainAgendaslots()
    }
    return domainList
}
