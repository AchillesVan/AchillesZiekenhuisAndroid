package com.example.achillesziekenhuis.ui.afspraakOverview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.achillesziekenhuis.network.ApiAgendaslot
import com.example.achillesziekenhuis.ui.ZiekenhuisAppAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisBottomAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisScaffold
import com.example.achillesziekenhuis.ui.dokterOverview.DokterOverviewViewModel
import java.time.LocalTime

@Composable
fun AfspraakOverview(
    modifier: Modifier = Modifier,
    rizivNummer: String,
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    goToLogin: () -> Unit,
) {
    val dokter =
        viewModel.uiDokterListState.collectAsState().value.dokterList.find { it.rizivNummer == rizivNummer }

    var date by remember {
        mutableStateOf("Selecteer datum")
    }

    var tijdslot by remember {
        mutableStateOf("-- Selecteer tijdstip --")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    val setTijdslot: (String) -> Unit = {
        tijdslot = it
    }

    val gebruikerState = viewModel.uiGebruikerState.collectAsState()

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var showDropDown by remember {
        mutableStateOf(false)
    }

    var showErrorDialog by remember {
        mutableStateOf(false)
    }

    var showConfirmDialog by remember {
        mutableStateOf(false)
    }

    ZiekenhuisScaffold(
        modifier = modifier,
        canNavigateBack = canNavigateBack,
        navigateUp = navigateUp,
        currentScreenTitle = "Afspraak maken",
        goHome = goHome,
        goToAbout = goToAbout,
        goToLogin = goToLogin,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    text = "Dokter: ${dokter?.voornaam} ${dokter?.familienaam}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Row {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    text = "Afdeling: ${dokter?.afdeling}",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Datum: ",
                )
                Button(onClick = { showDatePicker = true }) {
                    Text(text = date)
                }
            }
            if (showDropDown) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ZiekenhuisDropDown(
                        setSelected = setTijdslot,
                        defaultText = "-- Selecteer tijdstip --",
                        items = viewModel.dailyAgendaslots.map {
                            it.value
                        }.filter { value ->
                            value !in viewModel.uiAgendaslotListState.value.agendaslotList.map {
                                it.startTijd.toString()
                            }
                        },
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(onClick = {
                    try {
                        val afspraak = ApiAgendaslot.create(
                            rizivNummer = rizivNummer,
                            rijksregisternummer = gebruikerState.value.gebruiker?.rijksregisternummer ?: "",
                            startTijd = tijdslot,
                            datum = date,
                        )
                        viewModel.maakAfspraak(afspraak)
                        showConfirmDialog = true
                    } catch (e: IllegalArgumentException) {
                        errorMessage = e.message.toString()
                        showErrorDialog = true
                    }
                }) {
                    Text(text = "Maak afspraak")
                }
            }
        }

        if (showDatePicker) {
            ZiekenhuisDatePickerDialog(
                onDateSelected = {
                    date = it
                    viewModel.getAgendaslotsByRizivAndDate(rizivNummer, date)
                    showDropDown = true
                },
                onDismiss = { showDatePicker = false },
            )
        }

        if (showErrorDialog) {
            AlertDialog(
                icon = {
                    Icon(Icons.Default.Error, contentDescription = "Example Icon")
                },
                title = {
                    Text(text = "Afspraak maken mislukt")
                },
                text = {
                    Text(text = errorMessage)
                },
                onDismissRequest = {
                    showErrorDialog = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showErrorDialog = false
                        }
                    ) {
                        Text("Ok")
                    }
                },
                dismissButton = {}

            )
        }

        if (showConfirmDialog) {
            AlertDialog(
                icon = {
                    Icon(Icons.Default.Check, contentDescription = "Example Icon")
                },
                title = {
                    Text(text = "Afspraak werd gemaakt!")
                },
                text = {
                    Text(text = "Uw afspraak bij ${dokter?.voornaam} ${dokter?.familienaam} op $date om $tijdslot werd gemaakt.")
                },
                onDismissRequest = {
                    showConfirmDialog = false
                    goHome()
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showConfirmDialog = false
                            goHome()
                        }
                    ) {
                        Text("Ok")
                    }
                },
                dismissButton = {}

            )
        }
    }
}
