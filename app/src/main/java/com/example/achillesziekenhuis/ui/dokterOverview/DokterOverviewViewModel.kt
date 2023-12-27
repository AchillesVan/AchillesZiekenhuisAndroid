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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

class DokterOverviewViewModel(
    private val doktersRepository: DoktersRepository,
    private val agendaslotRepository: AgendaslotRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DokterOverviewState())
    val uiState: StateFlow<DokterOverviewState> = _uiState.asStateFlow()

    lateinit var uiDokterListState: StateFlow<DokterListState>
    lateinit var uiAgendaslotListState: StateFlow<AgendaslotListState>
    lateinit var uiAfdelingListState: StateFlow<AfdelingListState>


    var dokterApiState: DokterApiState by mutableStateOf(DokterApiState.Loading)
        private set

    var afspraakApiState: AgendaslotApiState by mutableStateOf(AgendaslotApiState.Loading)
        private set

    init {
        getRepoDokters()
        getRepoAfdelingen()
        Log.i("vm inspection", "DokterOverviewViewModel init")

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
                    Instance = DokterOverviewViewModel(
                        doktersRepository = dokterRepository,
                        agendaslotRepository = agendaslotRepository,
                        )
                }
                Instance!!
            }
        }
    }

    fun getRepoDokters() {
        try {
            viewModelScope.launch { doktersRepository.refresh() }
                .invokeOnCompletion { throwable ->
                    if (throwable is CancellationException) {
                        // Log when viewModelScope is cancelled
                        Log.d("ViewModelScope", "viewModelScope is cancelled")
                    }
                }
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
                .invokeOnCompletion { throwable ->
                    if (throwable is CancellationException) {
                        // Log when viewModelScope is cancelled
                        Log.d("ViewModelScope", "viewModelScope is cancelled")
                    }
                }
            uiAfdelingListState = doktersRepository.getAfdelingen().map {
                AfdelingListState(it)
            }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = AfdelingListState(),
                )

            Log.d("DokterOverviewViewModel", "getRepoAfdelingen: ${uiAfdelingListState.value.afdelingList}")
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



    private fun getRepoAfspraken(rijksregisternummer: String) {
        try {
            viewModelScope.launch { agendaslotRepository.refresh() }
                .invokeOnCompletion { throwable ->
                    if (throwable is CancellationException) {
                        // Log when viewModelScope is cancelled
                        Log.d("ViewModelScope", "viewModelScope is cancelled")
                    }
                }
            uiAgendaslotListState = agendaslotRepository.getByRRN(rijksregisternummer).map { AgendaslotListState(it) }
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
