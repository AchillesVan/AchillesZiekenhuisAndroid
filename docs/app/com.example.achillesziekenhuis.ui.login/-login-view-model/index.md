//[app](../../../index.md)/[com.example.achillesziekenhuis.ui.login](../index.md)/[LoginViewModel](index.md)

# LoginViewModel

[androidJvm]\
class [LoginViewModel](index.md)(val setUserCallback: ([Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the [LoginScreen](../-login-screen.md) screen.

## Constructors

| | |
|---|---|
| [LoginViewModel](-login-view-model.md) | [androidJvm]<br>constructor(setUserCallback: ([Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [setUserCallback](set-user-callback.md) | [androidJvm]<br>val [setUserCallback](set-user-callback.md): ([Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Callback to set the user in the AppContainer. |
| [userIsAuthenticated](user-is-authenticated.md) | [androidJvm]<br>var [userIsAuthenticated](user-is-authenticated.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) that indicates if the user is authenticated. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [onLogin](on-login.md) | [androidJvm]<br>fun [onLogin](on-login.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), auth: Auth0, setUser: ([Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onSuccessNavigation: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Login with Auth0. |
| [onLogOut](on-log-out.md) | [androidJvm]<br>fun [onLogOut](on-log-out.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), auth: Auth0, onSuccessNavigation: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Logout with Auth0. |
| [setUser](set-user.md) | [androidJvm]<br>fun [setUser](set-user.md)(auth0User: [Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md))<br>Set the user in the AppContainer. |
