package com.example.achillesziekenhuis.ui.dokterOverview

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.achillesziekenhuis.DoktersApplication
import com.example.achillesziekenhuis.data.AgendaslotRepository
import com.example.achillesziekenhuis.data.DoktersRepository
import com.example.achillesziekenhuis.data.GebruikersRepository
import com.example.achillesziekenhuis.model.ListAgendaslot
import com.example.achillesziekenhuis.network.ApiAgendaslot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel for the [DokterOverview] screen and [AfspraakOverview] screen.
 */
class DokterOverviewViewModel(
    private val doktersRepository: DoktersRepository,
    private val agendaslotRepository: AgendaslotRepository,
    private val gebruikersRepository: GebruikersRepository,
    auth0id: String,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DokterOverviewState())
    /**
     * [StateFlow] of the current [DokterOverviewState].
     */
    val uiState: StateFlow<DokterOverviewState> = _uiState.asStateFlow()

    /**
     * [StateFlow] of the current [DokterListState].
     */
    lateinit var uiDokterListState: StateFlow<DokterListState>
    /**
     * [StateFlow] of the current [AgendaslotListState].
     */
    lateinit var uiAgendaslotListState: StateFlow<AgendaslotListState>
    /**
     * [StateFlow] of the current [AfdelingListState].
     */
    lateinit var uiAfdelingListState: StateFlow<AfdelingListState>
    /**
     * [StateFlow] of the current [GebruikerState].
     */
    lateinit var uiGebruikerState: StateFlow<GebruikerState>

    /**
     * List<[ListAgendaslot]> that represents the daily available agendaslots.
     */
    lateinit var dailyAgendaslots: List<ListAgendaslot>

    /**
     * [MutableStateFlow] of the current [DokterApiState].
     */
    var dokterApiState: DokterApiState by mutableStateOf(DokterApiState.Loading)
        private set

    /**
     * [MutableStateFlow] of the current [AgendaslotApiState].
     */
    var afspraakApiState: AgendaslotApiState by mutableStateOf(AgendaslotApiState.Loading)
        private set

    /**
     * [MutableStateFlow] of the current [GebruikerApiState].
     */
    var gebruikerApiState: GebruikerApiState by mutableStateOf(GebruikerApiState.Loading)
        private set

    init {
        getRepoDokters()
        getRepoAfdelingen()
        getGebruikerByAuth0id(auth0id)
        getDailyAgendaslots()
        Log.i("vm inspection", "DokterOverviewViewModel init")
//        Log.d("DokterOverviewViewModel", "Gebruiker: ${uiGebruikerState.value.gebruiker}")
    }

    /**
     * [MutableStateFlow] of the current [WorkerState].
     */
    lateinit var wifiWorkerState: StateFlow<WorkerState>

    companion object {
        /**
         * Factory that returns a Singleton Object of [DokterOverviewViewModel].
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DoktersApplication)
                val dokterRepository = application.container.doktersRepository
                val agendaslotRepository = application.container.agendaslotRepository
                val gebruikersRepository = application.container.gebruikersRepository
                DokterOverviewViewModel(
                    doktersRepository = dokterRepository,
                    agendaslotRepository = agendaslotRepository,
                    gebruikersRepository = gebruikersRepository,
                    auth0id = application.container.getAuth0Id(),
                )
            }
        }
    }

/**
 * Retrieves all the [Dokter]s from Api or database and stores them in [uiDokterListState].
 */
fun getRepoDokters() {
    try {
        viewModelScope.launch { doktersRepository.refresh() }
        val dokters = doktersRepository.getDokters()
        uiDokterListState = dokters.map { DokterListState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = DokterListState(),
            )
        dokterApiState = DokterApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
    } catch (networkError: IOException) {
        dokterApiState = DokterApiState.Error
    }
}

/**
 * Retrieves all the afdelingen from the database and stores them in [uiAfdelingListState].
 */
fun getRepoAfdelingen() {
    try {
        viewModelScope.launch { doktersRepository.refresh() }
        uiAfdelingListState = doktersRepository.getAfdelingen().map {
            AfdelingListState(it)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = AfdelingListState(),
            )

//            Log.d("DokterOverviewViewModel", "getRepoAfdelingen: ${uiAfdelingListState.value.afdelingList}")
        dokterApiState = DokterApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
    } catch (networkError: IOException) {
        dokterApiState = DokterApiState.Error
    }
}

/**
 * Retrieves the [Gebruiker] with a specific Auth0 ID from the database and stores it in [uiGebruikerState].
 */
fun getGebruikerByAuth0id(auth0id: String) {
    try {
        Log.d("DokterOverviewViewModel", "getGebruikerByAuth0id: $auth0id")
        viewModelScope.launch { gebruikersRepository.refresh() }
        uiGebruikerState = gebruikersRepository.getGebruikerByAuth0id(auth0id).map {
            GebruikerState(it)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = GebruikerState(),
            )
        gebruikerApiState = GebruikerApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
        Log.d(
            "DokterOverviewViewModel",
            "End of getGebruikerByAuth0id: ${uiGebruikerState.value.gebruiker}"
        )
    } catch (networkError: IOException) {
        dokterApiState = DokterApiState.Error
    }
}

/**
 * Retrieves all the daily agendaslots from the Api and stores them in [dailyAgendaslots].
 */
fun getDailyAgendaslots() {
    try {
        viewModelScope.launch {
            agendaslotRepository.getDailyAgendaslots().collect {
                dailyAgendaslots = it
            }
        }
        afspraakApiState = AgendaslotApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
    } catch (networkError: IOException) {
        afspraakApiState = AgendaslotApiState.Error
    }
}


/**
 * Gets the [Agendaslot]s of a specific [Dokter] on a specific date from the Api and stores them in [uiAgendaslotListState].
 */
fun getAgendaslotsByRizivAndDate(rizivNummer: String, date: String) {
    try {
//            viewModelScope.launch { agendaslotRepository.refresh() }
        Log.d("DokterOverviewViewModel", "getAgendaslotsByRizivAndDate: $rizivNummer, $date")
        uiAgendaslotListState = agendaslotRepository.getByRizivAndDate(rizivNummer = rizivNummer, date = date)
            .map { AgendaslotListState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = AgendaslotListState(),
            )
        afspraakApiState = AgendaslotApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
    } catch (networkError: IOException) {
        afspraakApiState = AgendaslotApiState.Error
    }
}

/**
 * Posts a new [ApiAgendaslot] to the Api.
 */
fun maakAfspraak(agendaslot: ApiAgendaslot) {
    try {
        viewModelScope.launch { agendaslotRepository.insertAgendaslot(agendaslot) }
        afspraakApiState = AgendaslotApiState.Success

        wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkerState(),
        )
    } catch (networkError: IOException) {
        afspraakApiState = AgendaslotApiState.Error
    }
}
}
