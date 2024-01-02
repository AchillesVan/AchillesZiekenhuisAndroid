//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[CachingGebruikersRepository](index.md)

# CachingGebruikersRepository

[androidJvm]\
class [CachingGebruikersRepository](index.md)(gebruikerDao: [GebruikerDao](../../com.example.achillesziekenhuis.data.database/-gebruiker-dao/index.md), gebruikerApiService: [GebruikerApiService](../../com.example.achillesziekenhuis.network/-gebruiker-api-service/index.md), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [GebruikersRepository](../-gebruikers-repository/index.md)

Concrete implementation of the [GebruikersRepository](../-gebruikers-repository/index.md) interface. This class is responsible for fetching gebruikers from the network and storing them on disk.

## Constructors

| | |
|---|---|
| [CachingGebruikersRepository](-caching-gebruikers-repository.md) | [androidJvm]<br>constructor(gebruikerDao: [GebruikerDao](../../com.example.achillesziekenhuis.data.database/-gebruiker-dao/index.md), gebruikerApiService: [GebruikerApiService](../../com.example.achillesziekenhuis.network/-gebruiker-api-service/index.md), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>open override var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [getAllGebruikers](get-all-gebruikers.md) | [androidJvm]<br>open override fun [getAllGebruikers](get-all-gebruikers.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)&gt;&gt;<br>Returns all gebruikers from the database. |
| [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md) | [androidJvm]<br>open override fun [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md)(auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)&gt;<br>Returns a gebruiker by their auth0id. |
| [insertGebruiker](insert-gebruiker.md) | [androidJvm]<br>open suspend override fun [insertGebruiker](insert-gebruiker.md)(gebruiker: [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md))<br>Inserts a gebruiker into the database. |
| [refresh](refresh.md) | [androidJvm]<br>open suspend override fun [refresh](refresh.md)()<br>Refreshes the gebruikers in the database. |
