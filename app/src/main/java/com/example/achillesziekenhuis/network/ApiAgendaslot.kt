package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.ListAgendaslot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Serializable
data class ApiAgendaslot(
    var id: Int = 0,
    var riziv_nummer: String = "",
    var rijksregisternummer: String = "",
    var start_tijd: String = "",
    var eind_tijd: String = "",
) {
    companion object {
        fun create(
            rizivNummer: String,
            rijksregisternummer: String,
            datum: String,
            startTijd: String,
        ): ApiAgendaslot {
            if (rizivNummer.filter { it.isDigit() }.length != 11) {
                throw IllegalArgumentException("Ongeldig Rizivnummer.")
            } else if (rijksregisternummer.filter { it.isDigit() }.length != 11) {
                throw IllegalArgumentException("Ongeldig Rijksregisternummer.")
            } else if (datum == "Selecteer datum") {
                throw IllegalArgumentException("Geef een datum in.")
            }
            else if (LocalDate.parse(datum).isBefore(LocalDate.now())) {
                throw IllegalArgumentException("Ongeldige datum.")
            } else if (startTijd.length != 8 || !startTijd.contains(":") || startTijd.substring(2, 3) != ":") {
                throw IllegalArgumentException("Ongeldige start- en eindtijd.")
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

    fun ApiAgendaslot.asDomainAgendaslot(): Agendaslot {
        return Agendaslot(
            this.id,
            this.riziv_nummer,
            this.rijksregisternummer,
            LocalDateTime.parse(this.start_tijd),
            LocalDateTime.parse(this.eind_tijd),
        )
    }

    fun List<ApiAgendaslot>.asDomainAgendaslots(): List<Agendaslot> {
        var domainList = this.map {
            it.asDomainAgendaslot()
        }
        return domainList
    }

    fun Flow<List<ApiAgendaslot>>.asDomainAgendaslots(): Flow<List<Agendaslot>> {
        var domainList = this.map {
            it.asDomainAgendaslots()
        }
        return domainList
    }

@Serializable
data class ApiListAgendaslot(
    var value: String = "",
    var label: String = "",
)

fun ApiListAgendaslot.asDomainListAgendaslot(): ListAgendaslot {
    return ListAgendaslot(
        this.value,
        this.label,
    )
}

fun List<ApiListAgendaslot>.asDomainListAgendaslots(): List<ListAgendaslot> {
    var domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}
