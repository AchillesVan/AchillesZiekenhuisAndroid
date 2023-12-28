package com.example.achillesziekenhuis.ui.dokterOverview

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.achillesziekenhuis.ui.ZiekenhuisAppAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisBottomAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DokterOverview(
    modifier: Modifier = Modifier,
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    navigate: (String) -> Unit,
) {
    val dokterApiState = viewModel.dokterApiState

    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent,
        topBar = {
            ZiekenhuisAppAppBar(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                currentScreenTitle = "",
            )
        },
        bottomBar = {
            ZiekenhuisBottomAppBar(
                goHome = goHome,
                goToAbout = goToAbout,
            )
        },
    ) {
            innerPadding ->

        Box(modifier = Modifier
            .padding(innerPadding))
        {
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
    viewModel: DokterOverviewViewModel = viewModel(factory = DokterOverviewViewModel.Factory),
    navigate: (String) -> Unit,
) {
    val lazyListState = rememberLazyGridState()

    val dokterOverviewState by viewModel.uiState.collectAsState()

    val dokterListState by viewModel.uiDokterListState.collectAsState()

    LazyVerticalGrid(
        modifier = modifier,
        state = lazyListState,
        columns = GridCells.Adaptive(minSize = 128.dp),
    ) {
        items(dokterListState.dokterList) {
            DokterItem(
                dokter = it,
                navigate = navigate,
            )
        }
    }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(dokterOverviewState.scrollActionIdx) {
        if (dokterOverviewState.scrollActionIdx != 0) {
            coroutineScope.launch {
                lazyListState.animateScrollToItem(dokterOverviewState.scrollActionIdx)
            }
        }
    }
}
