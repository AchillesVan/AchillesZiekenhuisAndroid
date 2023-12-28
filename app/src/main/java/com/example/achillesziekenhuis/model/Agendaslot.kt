package com.example.achillesziekenhuis.model

import java.time.LocalDateTime

class Agendaslot(
    var id: Int = 0,
    var rizivNummer: String = "",
    var rijksregisternummer: String = "",
    var startTijd: LocalDateTime = LocalDateTime.now(),
    var eindTijd: LocalDateTime = LocalDateTime.now(),
)

class ListAgendaslot(
    var value: String = "",
    var label: String = "",
)
