package com.example.achillesziekenhuis.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.achillesziekenhuis.ui.afspraakOverview.AfspraakOverview
import com.example.achillesziekenhuis.ui.dokterOverview.DokterOverview
import com.example.achillesziekenhuis.ui.login.LoginScreen

@Composable
fun navComponent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = DokterOverviewScreen.Login.name,
        modifier = modifier,
    ) {
        composable(
            route = DokterOverviewScreen.Login.name,
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = DokterOverviewScreen.Start.name,
        ) {
            DokterOverview(
                navigate = navController::navigate,
            )
        }
        composable(
            route = DokterOverviewScreen.About.name,
        ) {
            Text("About")
        }
        composable(
            route = "${DokterOverviewScreen.Appointment.name}/{rizivNummer}",
        ) {
            AfspraakOverview(
                rizivNummer = it.arguments?.getString("rizivNummer") ?: "",
            )
        }
    }
}
