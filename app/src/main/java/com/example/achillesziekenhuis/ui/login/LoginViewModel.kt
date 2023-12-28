package com.example.achillesziekenhuis.ui.login

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.example.achillesziekenhuis.DoktersApplication
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.model.Auth0User

class LoginViewModel(
    val setUserCallback: (Auth0User) -> Unit,
): ViewModel() {

    var userIsAuthenticated: Boolean by mutableStateOf(false)

    companion object {
        private var Instance: LoginViewModel? = null
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                if (Instance == null) {
                    val application = (this[APPLICATION_KEY] as DoktersApplication)

                    Instance = LoginViewModel(
                        setUserCallback = application.container::setUser,
                    )
                }
                Instance!!
            }
        }
    }

    fun onLogin(context: Context, auth: Auth0,  setUser: (Auth0User) -> Unit, onSuccessNavigation: () -> Unit) {
        WebAuthProvider
            .login(auth)
            .withScheme(context.getString(R.string.com_auth0_scheme))
            .withAudience(context.getString(R.string.com_auth0_audience))
            .start(
                context,
                object : Callback<Credentials, AuthenticationException> {
                    override fun onFailure(error: AuthenticationException) {
                    }

                    override fun onSuccess(result: Credentials) {
                        val accessToken = result.accessToken
                        val auth0User = Auth0User(accessToken)
                        setUser(auth0User)
                        userIsAuthenticated = true
                        onSuccessNavigation()
                    }
                },
            )
    }

    fun onLogOut(context: Context, auth: Auth0, onSuccessNavigation: () -> Unit) {
        WebAuthProvider.logout(auth)
            .withScheme(context.getString(R.string.com_auth0_scheme))
            .start(
                context,
                object : Callback<Void?, AuthenticationException> {
                    override fun onFailure(error: AuthenticationException) {
                    }

                    override fun onSuccess(result: Void?) {
                        userIsAuthenticated = false
                        onSuccessNavigation()
                    }
                },
            )
    }

    fun setUser(auth0User: Auth0User) {
        setUserCallback(auth0User)
    }
}