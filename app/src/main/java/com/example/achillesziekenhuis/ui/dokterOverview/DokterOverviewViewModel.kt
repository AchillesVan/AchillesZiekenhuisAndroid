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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

class DokterOverviewViewModel(
    private val doktersRepository: DoktersRepository,
    private val agendaslotRepository: AgendaslotRepository,
    private val gebruikersRepository: GebruikersRepository,
    auth0id: String,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DokterOverviewState())
    val uiState: StateFlow<DokterOverviewState> = _uiState.asStateFlow()

    lateinit var uiDokterListState: StateFlow<DokterListState>
    lateinit var uiAgendaslotListState: StateFlow<AgendaslotListState>
    lateinit var uiAfdelingListState: StateFlow<AfdelingListState>
    lateinit var uiGebruikerState: StateFlow<GebruikerState>

    lateinit var dailyAgendaslots: List<ListAgendaslot>

    var dokterApiState: DokterApiState by mutableStateOf(DokterApiState.Loading)
        private set

    var afspraakApiState: AgendaslotApiState by mutableStateOf(AgendaslotApiState.Loading)
        private set

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

    lateinit var wifiWorkerState: StateFlow<WorkerState>

    companion object {
        private var Instance: DokterOverviewViewModel? = null
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                if (Instance == null) {
                    val application = (this[APPLICATION_KEY] as DoktersApplication)
                    val dokterRepository = application.container.doktersRepository
                    val agendaslotRepository = application.container.agendaslotRepository
                    val gebruikersRepository = application.container.gebruikersRepository
                    Instance = DokterOverviewViewModel(
                        doktersRepository = dokterRepository,
                        agendaslotRepository = agendaslotRepository,
                        gebruikersRepository = gebruikersRepository,
                        auth0id = application.container.getAuth0Id(),
                        )
                }
                Instance!!
            }
        }
    }

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

            wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = WorkerState(),
            )
        } catch (networkError: IOException) {
            dokterApiState = DokterApiState.Error
        }
    }

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

            wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = WorkerState(),
            )
        } catch (networkError: IOException) {
            dokterApiState = DokterApiState.Error
        }
    }

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

            wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = WorkerState(),
            )
            Log.d("DokterOverviewViewModel", "End of getGebruikerByAuth0id: ${uiGebruikerState.value.gebruiker}")
        } catch (networkError: IOException) {
            dokterApiState = DokterApiState.Error
        }
    }

    fun getDailyAgendaslots() {
        try {
            viewModelScope.launch {
                agendaslotRepository.getDailyAgendaslots().collect {
                    dailyAgendaslots = it
                }
            }
            afspraakApiState = AgendaslotApiState.Success

            wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = WorkerState(),
            )
        } catch (networkError: IOException) {
            afspraakApiState = AgendaslotApiState.Error
        }
    }


    fun getAgendaslotsByRizivAndDate(rizivNummer: String, startTime: String) {
        try {
            viewModelScope.launch { agendaslotRepository.refresh() }
            uiAgendaslotListState = agendaslotRepository.getByRizivAndDate(rizivNummer, startTime).map { AgendaslotListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = AgendaslotListState(),
                )
            afspraakApiState = AgendaslotApiState.Success

            wifiWorkerState = doktersRepository.wifiWorkInfo.map { WorkerState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = WorkerState(),
            )
        } catch (networkError: IOException) {
            afspraakApiState = AgendaslotApiState.Error
        }
    }
}
