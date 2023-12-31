package com.example.achillesziekenhuis.model

class ListAgendaslot(
    var value: String = "",
    var label: String = "",
) {
    override fun equals(other: Any?): Boolean {
        if (other !is ListAgendaslot) return false
        if (other === this) return true
        return other.value == this.value && other.label == this.label
    }
}