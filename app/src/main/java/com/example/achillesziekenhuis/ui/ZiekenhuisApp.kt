package com.example.achillesziekenhuis.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.achillesziekenhuis.ui.navigation.NavComponent

/**
 * Main component for the app.
 */
@Composable
fun ZiekenhuisApp(
    navController: NavHostController = rememberNavController(),
) {
    NavComponent(navController)
}
