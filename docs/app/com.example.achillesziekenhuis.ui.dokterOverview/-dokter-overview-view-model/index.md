//[app](../../../index.md)/[com.example.achillesziekenhuis.ui.dokterOverview](../index.md)/[DokterOverviewViewModel](index.md)

# DokterOverviewViewModel

[androidJvm]\
class [DokterOverviewViewModel](index.md)(doktersRepository: [DoktersRepository](../../com.example.achillesziekenhuis.data/-dokters-repository/index.md), agendaslotRepository: [AgendaslotRepository](../../com.example.achillesziekenhuis.data/-agendaslot-repository/index.md), gebruikersRepository: [GebruikersRepository](../../com.example.achillesziekenhuis.data/-gebruikers-repository/index.md), auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the [DokterOverview](../-dokter-overview.md) screen and AfspraakOverview screen.

## Constructors

| | |
|---|---|
| [DokterOverviewViewModel](-dokter-overview-view-model.md) | [androidJvm]<br>constructor(doktersRepository: [DoktersRepository](../../com.example.achillesziekenhuis.data/-dokters-repository/index.md), agendaslotRepository: [AgendaslotRepository](../../com.example.achillesziekenhuis.data/-agendaslot-repository/index.md), gebruikersRepository: [GebruikersRepository](../../com.example.achillesziekenhuis.data/-gebruikers-repository/index.md), auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [afspraakApiState](afspraak-api-state.md) | [androidJvm]<br>var [afspraakApiState](afspraak-api-state.md): [AgendaslotApiState](../-agendaslot-api-state/index.md)<br>MutableStateFlow of the current [AgendaslotApiState](../-agendaslot-api-state/index.md). |
| [dailyAgendaslots](daily-agendaslots.md) | [androidJvm]<br>lateinit var [dailyAgendaslots](daily-agendaslots.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ListAgendaslot](../../com.example.achillesziekenhuis.model/-list-agendaslot/index.md)&gt;<br>List<[ListAgendaslot](../../com.example.achillesziekenhuis.model/-list-agendaslot/index.md)> that represents the daily available agendaslots. |
| [dokterApiState](dokter-api-state.md) | [androidJvm]<br>var [dokterApiState](dokter-api-state.md): [DokterApiState](../-dokter-api-state/index.md)<br>MutableStateFlow of the current [DokterApiState](../-dokter-api-state/index.md). |
| [gebruikerApiState](gebruiker-api-state.md) | [androidJvm]<br>var [gebruikerApiState](gebruiker-api-state.md): [GebruikerApiState](../-gebruiker-api-state/index.md)<br>MutableStateFlow of the current [GebruikerApiState](../-gebruiker-api-state/index.md). |
| [uiAfdelingListState](ui-afdeling-list-state.md) | [androidJvm]<br>lateinit var [uiAfdelingListState](ui-afdeling-list-state.md): StateFlow&lt;[AfdelingListState](../-afdeling-list-state/index.md)&gt;<br>StateFlow of the current [AfdelingListState](../-afdeling-list-state/index.md). |
| [uiAgendaslotListState](ui-agendaslot-list-state.md) | [androidJvm]<br>lateinit var [uiAgendaslotListState](ui-agendaslot-list-state.md): StateFlow&lt;[AgendaslotListState](../-agendaslot-list-state/index.md)&gt;<br>StateFlow of the current [AgendaslotListState](../-agendaslot-list-state/index.md). |
| [uiDokterListState](ui-dokter-list-state.md) | [androidJvm]<br>lateinit var [uiDokterListState](ui-dokter-list-state.md): StateFlow&lt;[DokterListState](../-dokter-list-state/index.md)&gt;<br>StateFlow of the current [DokterListState](../-dokter-list-state/index.md). |
| [uiGebruikerState](ui-gebruiker-state.md) | [androidJvm]<br>lateinit var [uiGebruikerState](ui-gebruiker-state.md): StateFlow&lt;[GebruikerState](../-gebruiker-state/index.md)&gt;<br>StateFlow of the current [GebruikerState](../-gebruiker-state/index.md). |
| [uiState](ui-state.md) | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[DokterOverviewState](../-dokter-overview-state/index.md)&gt;<br>StateFlow of the current [DokterOverviewState](../-dokter-overview-state/index.md). |
| [wifiWorkerState](wifi-worker-state.md) | [androidJvm]<br>lateinit var [wifiWorkerState](wifi-worker-state.md): StateFlow&lt;[WorkerState](../-worker-state/index.md)&gt;<br>MutableStateFlow of the current [WorkerState](../-worker-state/index.md). |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../com.example.achillesziekenhuis.ui.login/-login-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../com.example.achillesziekenhuis.ui.login/-login-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [getAgendaslotsByRizivAndDate](get-agendaslots-by-riziv-and-date.md) | [androidJvm]<br>fun [getAgendaslotsByRizivAndDate](get-agendaslots-by-riziv-and-date.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Gets the Agendaslots of a specific Dokter on a specific date from the Api and stores them in [uiAgendaslotListState](ui-agendaslot-list-state.md). |
| [getDailyAgendaslots](get-daily-agendaslots.md) | [androidJvm]<br>fun [getDailyAgendaslots](get-daily-agendaslots.md)()<br>Retrieves all the daily agendaslots from the Api and stores them in [dailyAgendaslots](daily-agendaslots.md). |
| [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md) | [androidJvm]<br>fun [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md)(auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Retrieves the Gebruiker with a specific Auth0 ID from the database and stores it in [uiGebruikerState](ui-gebruiker-state.md). |
| [getRepoAfdelingen](get-repo-afdelingen.md) | [androidJvm]<br>fun [getRepoAfdelingen](get-repo-afdelingen.md)()<br>Retrieves all the afdelingen from the database and stores them in [uiAfdelingListState](ui-afdeling-list-state.md). |
| [getRepoDokters](get-repo-dokters.md) | [androidJvm]<br>fun [getRepoDokters](get-repo-dokters.md)()<br>Retrieves all the Dokters from Api or database and stores them in [uiDokterListState](ui-dokter-list-state.md). |
| [maakAfspraak](maak-afspraak.md) | [androidJvm]<br>fun [maakAfspraak](maak-afspraak.md)(agendaslot: [ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md))<br>Posts a new [ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md) to the Api. |
