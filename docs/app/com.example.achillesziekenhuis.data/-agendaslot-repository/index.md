//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[AgendaslotRepository](index.md)

# AgendaslotRepository

interface [AgendaslotRepository](index.md)

Repository for fetching [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)s from the network and storing them on disk.

#### Inheritors

| |
|---|
| [CachingAgendaslotRepository](../-caching-agendaslot-repository/index.md) |
| [FakeApiAgendaslotRepository](../../com.example.achillesziekenhuis.fake/-fake-api-agendaslot-repository/index.md) |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>abstract var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [getByRizivAndDate](get-by-riziv-and-date.md) | [androidJvm]<br>abstract fun [getByRizivAndDate](get-by-riziv-and-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)&gt;&gt;<br>Returns the agendaslots of a doctor with a given riziv number and date. |
| [getByRRN](get-by-r-r-n.md) | [androidJvm]<br>abstract fun [getByRRN](get-by-r-r-n.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)&gt;&gt;<br>Returns the agendaslots of a patient with a given National Insureance number (rijksregisternummer). |
| [getDailyAgendaslots](get-daily-agendaslots.md) | [androidJvm]<br>abstract fun [getDailyAgendaslots](get-daily-agendaslots.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ListAgendaslot](../../com.example.achillesziekenhuis.model/-list-agendaslot/index.md)&gt;&gt;<br>Returns the start time of all available agendaslots per day. |
| [insertAgendaslot](insert-agendaslot.md) | [androidJvm]<br>abstract suspend fun [insertAgendaslot](insert-agendaslot.md)(agendaslot: [ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md))<br>Inserts an agendaslot into the database. |
