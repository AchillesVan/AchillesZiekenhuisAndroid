package com.example.achillesziekenhuis.ui.dokterOverview

import androidx.work.WorkInfo
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.Dokter

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

data class DokterListState(val dokterList: List<Dokter> = listOf())

data class AfdelingListState(val afdelingList: List<String> = listOf())

data class AgendaslotListState(val agendaslotList: List<Agendaslot> = listOf())

data class WorkerState(val workerInfo: WorkInfo? = null)

