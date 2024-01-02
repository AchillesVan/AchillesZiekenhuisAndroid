package com.example.achillesziekenhuis.model

import java.time.LocalDateTime

/**
 * Data class that represents an agendaslot.
 */
class Agendaslot(
    /**
     * Unique identifier for the agendaslot.
     */
    var id: Int = 0,
    /**
     * The riziv number of the doctor.
     */
    var rizivNummer: String = "",
    /**
     * The National Insurance number (rijksregisternummer) of the patient.
     */
    var rijksregisternummer: String = "",
    /**
     * The start time of the agendaslot.
     */
    var startTijd: LocalDateTime = LocalDateTime.now(),
)


