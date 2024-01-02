//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[GebruikerApiService](index.md)

# GebruikerApiService

[androidJvm]\
interface [GebruikerApiService](index.md)

API communication interface for the [ApiGebruiker](../-api-gebruiker/index.md) endpoints.

## Functions

| Name | Summary |
|---|---|
| [getAllGebruikers](get-all-gebruikers.md) | [androidJvm]<br>@GET(value = &quot;gebruikers&quot;)<br>abstract suspend fun [getAllGebruikers](get-all-gebruikers.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiGebruiker](../-api-gebruiker/index.md)&gt;<br>Returns a list of all available gebruikers. |
| [getGebruikersAsFlow](../get-gebruikers-as-flow.md) | [androidJvm]<br>fun [GebruikerApiService](index.md).[getGebruikersAsFlow](../get-gebruikers-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiGebruiker](../-api-gebruiker/index.md)&gt;&gt;<br>Extension function to get the gebruikers as a flow. |
