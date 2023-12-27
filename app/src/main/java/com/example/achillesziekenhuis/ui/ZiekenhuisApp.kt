package com.example.achillesziekenhuis.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.ui.navigation.DokterOverviewScreen
import com.example.achillesziekenhuis.ui.navigation.navComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZiekenhuisApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val canNavigateBack = navController.previousBackStackEntry?.destination?.route != DokterOverviewScreen.Login.name

    val navigateUp: () -> Unit = { navController.navigateUp() }

    val goHome: () -> Unit = {
        navController.popBackStack(
            DokterOverviewScreen.Start.name,
            inclusive = false,
        )
    }
    val goToAbout = { navController.navigate(DokterOverviewScreen.About.name) }

//    val currentScreenTitle = DokterOverviewScreen.valueOf(
//        backStackEntry?.destination?.route ?: DokterOverviewScreen.Start.name,
//    ).name

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            ZiekenhuisAppAppBar(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                currentScreenTitle = R.string.start_screen_title,
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

        navComponent(navController, Modifier.padding(innerPadding))

    }
}
