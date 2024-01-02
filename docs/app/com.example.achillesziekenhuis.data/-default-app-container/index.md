//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[DefaultAppContainer](index.md)

# DefaultAppContainer

[androidJvm]\
class [DefaultAppContainer](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](../-app-container/index.md)

Concrete implementation of the [AppContainer](../-app-container/index.md) interface. This class is responsible for providing the repositories.

## Constructors

| | |
|---|---|
| [DefaultAppContainer](-default-app-container.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [agendaslotRepository](agendaslot-repository.md) | [androidJvm]<br>open override val [agendaslotRepository](agendaslot-repository.md): [AgendaslotRepository](../-agendaslot-repository/index.md)<br>Returns a singleton instance of the [AgendaslotRepository](../-agendaslot-repository/index.md). |
| [doktersRepository](dokters-repository.md) | [androidJvm]<br>open override val [doktersRepository](dokters-repository.md): [DoktersRepository](../-dokters-repository/index.md)<br>Returns a singleton instance of the [DoktersRepository](../-dokters-repository/index.md). |
| [gebruikersRepository](gebruikers-repository.md) | [androidJvm]<br>open override val [gebruikersRepository](gebruikers-repository.md): [GebruikersRepository](../-gebruikers-repository/index.md)<br>Returns a singleton instance of the [GebruikersRepository](../-gebruikers-repository/index.md). |

## Functions

| Name | Summary |
|---|---|
| [getAuth0Id](get-auth0-id.md) | [androidJvm]<br>open override fun [getAuth0Id](get-auth0-id.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the current user's Auth0 ID. |
| [setUser](set-user.md) | [androidJvm]<br>open override fun [setUser](set-user.md)(auth0User: [Auth0User](../../com.example.achillesziekenhuis.model/-auth0-user/index.md))<br>Sets the current user. |
