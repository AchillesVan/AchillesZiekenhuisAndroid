package com.example.achillesziekenhuis.ui.afspraakOverview

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.achillesziekenhuis.ui.dokterOverview.DokterOverviewViewModel

@Composable
fun AfspraakOverview(
    modifier: Modifier = Modifier,
    rizivNummer: String,
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
) {
    val dokter = viewModel.uiDokterListState.collectAsState().value.dokterList.find { it.rizivNummer == rizivNummer }

    Box(modifier = modifier) {
        Text(text = dokter?.voornaam + " " + dokter?.familienaam)
    }
}
