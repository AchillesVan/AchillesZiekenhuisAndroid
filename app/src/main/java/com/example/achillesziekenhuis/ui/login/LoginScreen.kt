package com.example.achillesziekenhuis.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.auth0.android.Auth0
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.ui.navigation.DokterOverviewScreen
import com.example.achillesziekenhuis.ui.dokterOverview.DokterOverviewViewModel
import com.example.achillesziekenhuis.ui.theme.spacing

/**
 * The login screen of the app.
 *
 * @param viewModel The [DokterOverviewViewModel] to use.
 */
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(factory = LoginViewModel.Factory),
    navController: NavController,
) {
    val context = LocalContext.current

    val auth = Auth0(
        context.getString(R.string.com_auth0_client_id),
        context.getString(R.string.com_auth0_domain),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = MaterialTheme.spacing.large),
        verticalArrangement = Arrangement.spacedBy(space = MaterialTheme.spacing.large),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LoginButton(
                onClick = {
                    viewModel.onLogin(
                        context = context,
                        auth = auth,
                        setUser = viewModel::setUser,
                        onSuccessNavigation = {
                            navController.navigate(DokterOverviewScreen.Start.name)
                        },
                    )
                },
                modifier =
                Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenPreviewDark() = LoginScreenPreview()
