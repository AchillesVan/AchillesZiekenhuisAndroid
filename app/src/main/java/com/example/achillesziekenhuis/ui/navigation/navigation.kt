package com.example.achillesziekenhuis.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.achillesziekenhuis.ui.aboutPage.AboutPage
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

        val canNavigateBack = navController.previousBackStackEntry?.destination?.route != DokterOverviewScreen.Login.name
                && navController.currentBackStackEntry?.destination?.route != DokterOverviewScreen.Login.name

        val navigateUp: () -> Unit = { navController.navigateUp() }

        val goHome: () -> Unit = {
            navController.popBackStack(
                DokterOverviewScreen.Start.name,
                inclusive = false,
            )
        }
        val goToAbout = { navController.navigate(DokterOverviewScreen.About.name) }

        val goToLogin = { navController.navigate(DokterOverviewScreen.Login.name) }

        composable(
            route = DokterOverviewScreen.Login.name,
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = DokterOverviewScreen.Start.name,
        ) {
            DokterOverview(
                navigateUp = navigateUp,
                goHome = goHome,
                goToAbout = goToAbout,
                navigate = navController::navigate,
                goToLogin = goToLogin,
                )
        }
        composable(
            route = DokterOverviewScreen.About.name,
        ) {
            AboutPage(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                goHome = goHome,
                goToAbout = goToAbout,
                goToLogin = goToLogin,
            )
        }
        composable(
            route = "${DokterOverviewScreen.Appointment.name}/{rizivNummer}",
        ) {
            AfspraakOverview(
                rizivNummer = it.arguments?.getString("rizivNummer") ?: "",
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                goHome = goHome,
                goToAbout = goToAbout,
                goToLogin = goToLogin,
            )
        }
    }
}
