package com.example.achillesziekenhuis.ui.afspraakOverview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
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
import com.example.achillesziekenhuis.ui.ZiekenhuisAppAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisBottomAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisScaffold
import com.example.achillesziekenhuis.ui.dokterOverview.DokterOverviewViewModel

@Composable
fun AfspraakOverview(
    modifier: Modifier = Modifier,
    rizivNummer: String,
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
) {
    val dokter = viewModel.uiDokterListState.collectAsState().value.dokterList.find { it.rizivNummer == rizivNummer }

    val agendaslotListState by viewModel.uiAgendaslotListState.collectAsState()

    var date by remember {
        mutableStateOf("Open date picker dialog")
    }

    val gebruiker = viewModel.uiGebruikerState.collectAsState()

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var showDropdown by remember { mutableStateOf(false) }

    ZiekenhuisScaffold(
        modifier = modifier,
        topBar = {
            ZiekenhuisAppAppBar(
                canNavigateBack = canNavigateBack,
                currentScreenTitle = "",
                navigateUp = navigateUp,
            )
        },
        bottomBar = {
            ZiekenhuisBottomAppBar(
                goHome = goHome,
                goToAbout = goToAbout,
            )
        },
    ) {
        Column {
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
                modifier = Modifier.fillMaxWidth(),
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
            DropdownMenu(expanded = showDropdown, onDismissRequest = { showDropdown = false }) {
                viewModel.dailyAgendaslots.filter { it.value !=  }
            }
        }

        if (showDatePicker) {
            ZiekenhuisDatePickerDialog(
                onDateSelected = {
                    date = it
                    viewModel.getAgendaslotsByRizivAndDate(rizivNummer, date)
                                 },
                onDismiss = { showDatePicker = false },
            )
        }
    }
}
