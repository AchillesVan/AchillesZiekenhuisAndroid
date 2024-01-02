//[app](../../index.md)/[com.example.achillesziekenhuis.ui.login](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [LoginViewModel](-login-view-model/index.md) | [androidJvm]<br>class [LoginViewModel](-login-view-model/index.md)(val setUserCallback: ([Auth0User](../com.example.achillesziekenhuis.model/-auth0-user/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for the [LoginScreen](-login-screen.md) screen. |

## Functions

| Name | Summary |
|---|---|
| [LoginButton](-login-button.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LoginButton](-login-button.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>A button that is used to login. |
| [LoginScreen](-login-screen.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [LoginScreen](-login-screen.md)(viewModel: [LoginViewModel](-login-view-model/index.md) = viewModel(factory = LoginViewModel.Factory), navController: [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html))<br>The login screen of the app. |
