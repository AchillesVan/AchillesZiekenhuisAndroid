package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.model.ListAgendaslot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class ApiAgendaslot(
    var id: Int = 0,
    var rizivNummer: String = "",
    var rijksregisternummer: String = "",
    var startTijd: String= "",
    var eindTijd: String = "",
)

fun ApiAgendaslot.asDomainObject(): Agendaslot {
    return Agendaslot(
        this.id,
        this.rizivNummer,
        this.rijksregisternummer,
        LocalDateTime.parse(this.startTijd),
        LocalDateTime.parse(this.eindTijd),
    )
}

fun List<ApiAgendaslot>.asDomainObjects(): List<Agendaslot> {
    var domainList = this.map {
        it.asDomainObject()
    }
    return domainList
}

fun Flow<List<ApiAgendaslot>>.asDomainObjects(): Flow<List<Agendaslot>> {
    var domainList = this.map {
        it.asDomainObjects()
    }
    return domainList
}


@Serializable
data class ApiListAgendaslot(
    var value: String = "",
    var label: String = "",
)

fun ApiListAgendaslot.asDomainObject(): ListAgendaslot {
    return ListAgendaslot(
        this.value,
        this.label,
    )
}

fun List<ApiListAgendaslot>.asDomainObjects(): List<ListAgendaslot> {
    var domainList = this.map {
        it.asDomainObject()
    }
    return domainList
}