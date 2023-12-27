package com.example.achillesziekenhuis.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.achillesziekenhuis.model.Agendaslot
import java.time.LocalDateTime

@Entity(tableName = "agendaslots")
data class DbAgendaslot(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val rizivNummer: String = "",
    val rijksregisternummer: String = "",
    val startTijd: String = "",
    val eindTijd: String = "",
)

fun DbAgendaslot.asDomainAgendaslot(): Agendaslot {
    return Agendaslot(
        this.id,
        this.rizivNummer,
        this.rijksregisternummer,
        LocalDateTime.parse(this.startTijd),
        LocalDateTime.parse(this.eindTijd),
    )
}

fun Agendaslot.asDbAgendaslot(): DbAgendaslot {
    return DbAgendaslot(
        id = this.id,
        rizivNummer = this.rizivNummer,
        rijksregisternummer = this.rijksregisternummer,
        startTijd = this.startTijd.toString(),
        eindTijd = this.eindTijd.toString(),
    )
}

fun List<DbAgendaslot>.asDomainAgendaslots(): List<Agendaslot> {
    val agendaslotList = this.map {
        Agendaslot(
            it.id,
            it.rizivNummer,
            it.rijksregisternummer,
            LocalDateTime.parse(it.startTijd),
            LocalDateTime.parse(it.eindTijd),
        )
    }
    return agendaslotList
}


