package com.example.achillesziekenhuis.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.achillesziekenhuis.ui.navigation.navComponent

@Composable
fun ZiekenhuisApp(
    navController: NavHostController = rememberNavController(),
) {
    navComponent(navController)
}
