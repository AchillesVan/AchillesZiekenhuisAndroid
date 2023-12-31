package com.example.achillesziekenhuis.ui.dokterOverview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.achillesziekenhuis.ui.ZiekenhuisScaffold
import com.example.achillesziekenhuis.ui.afspraakOverview.ZiekenhuisDropDown
import kotlinx.coroutines.launch

@Composable
fun DokterOverview(
    modifier: Modifier = Modifier,
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    goToLogin: () -> Unit,
    navigate: (String) -> Unit,
) {

    val dokterApiState = viewModel.dokterApiState

    ZiekenhuisScaffold(
        modifier = modifier,
        canNavigateBack = false,
        navigateUp = navigateUp,
        currentScreenTitle = "Vind een dokter",
        goHome = goHome,
        goToAbout = goToAbout,
        goToLogin = goToLogin,
    ) {
        Box {
            when (dokterApiState) {
                is DokterApiState.Loading -> Text("Loading...")
                is DokterApiState.Error -> Text("Couldn't load...")
                is DokterApiState.Success -> DokterListComponent(
                    modifier = modifier,
                    navigate = navigate,
                    viewModel = viewModel,
                )
            }
        }
    }
}

@Composable
fun DokterListComponent(
    modifier: Modifier = Modifier,
    viewModel: DokterOverviewViewModel,
    navigate: (String) -> Unit,
) {
    val lazyListState = rememberLazyGridState()

    val dokterListState by viewModel.uiDokterListState.collectAsState()


    Column(
        modifier = modifier,
    ) {
        val defaultDropDownText = "-- Selecteer afdeling --"

        val afdelingListState by viewModel.uiAfdelingListState.collectAsState()

        var afdelingFilter by remember {
            mutableStateOf(defaultDropDownText)
        }

        val setAfdeling: (String) -> Unit = { afdeling ->
            afdelingFilter = afdeling
        }

        ZiekenhuisDropDown(
            modifier = Modifier
                .padding(8.dp),
            items = afdelingListState.afdelingList,
            setSelected = setAfdeling,
            defaultText = defaultDropDownText,
        )

        LazyVerticalGrid(
            modifier = modifier,
            state = lazyListState,
            columns = GridCells.Adaptive(minSize = 128.dp),
        ) {
            items(if (afdelingFilter == defaultDropDownText) dokterListState.dokterList else dokterListState.dokterList.filter { it.afdeling == afdelingFilter }) {
                DokterItem(
                    dokter = it,
                    navigate = navigate,
                )
            }
        }
    }

    val coroutineScope = rememberCoroutineScope()

    val dokterOverviewState by viewModel.uiState.collectAsState()

    LaunchedEffect(dokterOverviewState.scrollActionIdx) {
        if (dokterOverviewState.scrollActionIdx != 0) {
            coroutineScope.launch {
                lazyListState.animateScrollToItem(dokterOverviewState.scrollActionIdx)
            }
        }
    }
}
