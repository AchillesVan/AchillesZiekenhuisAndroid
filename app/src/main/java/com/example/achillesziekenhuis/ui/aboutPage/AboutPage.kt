package com.example.achillesziekenhuis.ui.aboutPage

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.achillesziekenhuis.ui.ZiekenhuisAppAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisBottomAppBar
import com.example.achillesziekenhuis.ui.ZiekenhuisScaffold

@Composable
fun AboutPage(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    goToLogin: () -> Unit,
) {
    ZiekenhuisScaffold(
        modifier = modifier,
        canNavigateBack = canNavigateBack,
        navigateUp = navigateUp,
        currentScreenTitle = "Over ons ziekenhuis",
        goHome = goHome,
        goToAbout = goToAbout,
        goToLogin = goToLogin,
    ) {
        Text(
            text = "About",
        )
    }
}
