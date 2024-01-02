package com.example.achillesziekenhuis.network

import com.example.achillesziekenhuis.model.ListAgendaslot
import kotlinx.serialization.Serializable

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
    val domainList = this.map {
        it.asDomainListAgendaslot()
    }
    return domainList
}