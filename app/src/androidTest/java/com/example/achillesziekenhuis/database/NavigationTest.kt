package com.example.achillesziekenhuis.database

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.achillesziekenhuis.ui.ZiekenhuisApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composableTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composableTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            ZiekenhuisApp(navController = navController)
        }
    }

    @Test
    fun verifyStartDestination() {
        composableTestRule
            .onNodeWithText("Log in")
            .assertIsDisplayed()
    }

    @Test
    fun navigateToForm() {
        composableTestRule
            .onNodeWithText("Log in")
            .performClick()
//        composableTestRule
//            .onNodeWithText("Routenummer")
//            .assertIsDisplayed()
    }
}