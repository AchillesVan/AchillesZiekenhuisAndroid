//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[GebruikersRepository](index.md)

# GebruikersRepository

interface [GebruikersRepository](index.md)

Repository for fetching [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)s from the network and storing them on disk.

#### Inheritors

| |
|---|
| [CachingGebruikersRepository](../-caching-gebruikers-repository/index.md) |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>abstract var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [getAllGebruikers](get-all-gebruikers.md) | [androidJvm]<br>abstract fun [getAllGebruikers](get-all-gebruikers.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)&gt;&gt;<br>Returns all gebruikers from the database. |
| [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md) | [androidJvm]<br>abstract fun [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md)(auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)&gt;<br>Returns a gebruiker by their auth0id. |
| [insertGebruiker](insert-gebruiker.md) | [androidJvm]<br>abstract suspend fun [insertGebruiker](insert-gebruiker.md)(gebruiker: [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md))<br>Inserts a gebruiker into the database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)()<br>Refreshes the gebruikers in the database. |
