package com.example.achillesziekenhuis.ui.dokterOverview

import androidx.work.WorkInfo
import com.example.achillesziekenhuis.model.Agendaslot
import com.example.achillesziekenhuis.model.Dokter
import com.example.achillesziekenhuis.model.Gebruiker

/**
 * State for [DokterOverviewScreen]
 */
data class DokterOverviewState(
    /**
     * State to remember scroll position of [DokterListComponent]
     */
    var scrollActionIdx: Int = 0,
)

/**
 * State for the dokterApi
 */
sealed interface DokterApiState {
    /**
     * Success state
     */
    object Success : DokterApiState
    /**
     * Error state
     */
    object Error : DokterApiState
    /**
     * Loading state
     */
    object Loading : DokterApiState
}

/**
 * State for the afdelingApi
 */
sealed interface AgendaslotApiState {
    /**
     * Success state
     */
    object Success : AgendaslotApiState
    /**
     * Error state
     */
    object Error : AgendaslotApiState
    /**
     * Loading state
     */
    object Loading : AgendaslotApiState
}

/**
 * State for the gebruikerApi
 */
sealed interface GebruikerApiState {
    /**
     * Success state
     */
    object Success : GebruikerApiState
    /**
     * Error state
     */
    object Error : GebruikerApiState
    /**
     * Loading state
     */
    object Loading : GebruikerApiState
}

/**
 * State that stores List<[Dokter]> for the [DokterListComponent]
 */
data class DokterListState(
    /**
     * List of [Dokter]s
     */
    val dokterList: List<Dokter> = listOf())

/**
 * State that stores List<[String]> for the [ZiekenhuisDropDown]
 */
data class AfdelingListState(
    /**
     * List of afdelingen
     */
    val afdelingList: List<String> = listOf())

/**
 * State that stores List<[Agendaslot]>
 */
data class AgendaslotListState(
    /**
     * List of [Agendaslot]s
     */
    val agendaslotList: List<Agendaslot> = listOf())

/**
 * State for wifiWorker info
 */
data class WorkerState(
    /**
     * [WorkInfo] of the wifiWorker
     */
    val workerInfo: WorkInfo? = null)

/**
 * State for [Gebruiker]
 */
data class GebruikerState(
    /**
     * [Gebruiker] of the logged in user
     */
    val gebruiker: Gebruiker? = null)
