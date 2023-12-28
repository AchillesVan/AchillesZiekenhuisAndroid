package com.example.achillesziekenhuis.ui.dokterOverview

import androidx.work.WorkInfo
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.model.Gebruiker

data class DokterOverviewState(
    var scrollActionIdx: Int = 0,
)

sealed interface DokterApiState {
    object Success : DokterApiState
    object Error : DokterApiState
    object Loading : DokterApiState
}

sealed interface AgendaslotApiState {
    object Success : AgendaslotApiState
    object Error : AgendaslotApiState
    object Loading : AgendaslotApiState
}

sealed interface GebruikerApiState {
    object Success : GebruikerApiState
    object Error : GebruikerApiState
    object Loading : GebruikerApiState
}

data class DokterListState(val dokterList: List<Dokter> = listOf())

data class AfdelingListState(val afdelingList: List<String> = listOf())

data class AgendaslotListState(val agendaslotList: List<Agendaslot> = listOf())

data class WorkerState(val workerInfo: WorkInfo? = null)

data class GebruikerState(val gebruiker: Gebruiker? = null)
