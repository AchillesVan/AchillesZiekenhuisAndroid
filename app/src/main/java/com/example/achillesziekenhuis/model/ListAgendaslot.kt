package com.example.achillesziekenhuis.model

/**
 * Represents a label-value pair for a list of agendaslots used to show
 * the available agendaslots in a dropdown menu.
 */
class ListAgendaslot(
    /**
     * The value of the agendaslot.
     */
    var value: String = "",
    /**
     * The label of the agendaslot.
     */
    var label: String = "",
) {
    override fun equals(other: Any?): Boolean {
        if (other !is ListAgendaslot) return false
        if (other === this) return true
        return other.value == this.value && other.label == this.label
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + label.hashCode()
        return result
    }
}