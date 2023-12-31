package com.example.achillesziekenhuis.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.auth0.android.Auth0
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.ui.login.LoginViewModel

@Composable
fun ZiekenhuisScaffold(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    currentScreenTitle: String,
    goHome: () -> Unit,
    goToAbout: () -> Unit,
    goToLogin: () -> Unit,
    viewModel: LoginViewModel = viewModel(factory = LoginViewModel.Factory),
    content: @Composable (Modifier) -> Unit,
) {
    val context = LocalContext.current

    val auth = Auth0(
        context.getString(R.string.com_auth0_client_id),
        context.getString(R.string.com_auth0_domain),
    )

    Scaffold(
        containerColor = Color.Transparent,
        topBar = { ZiekenhuisAppAppBar(
            canNavigateBack = canNavigateBack,
            navigateUp = navigateUp,
            currentScreenTitle = currentScreenTitle,
        ) },
        bottomBar = { ZiekenhuisBottomAppBar(
            goHome = goHome,
            goToAbout = goToAbout,
            logOut = {
                viewModel.onLogOut(
                    context = context,
                    auth = auth,
                    onSuccessNavigation = goToLogin,
                )
                goHome()
            },
        ) },
        content = { innerPadding ->
            Column(modifier = modifier.padding(innerPadding)) {
                content(Modifier)
            }
        }
    )
}
