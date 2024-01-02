//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[CachingAgendaslotRepository](index.md)

# CachingAgendaslotRepository

[androidJvm]\
class [CachingAgendaslotRepository](index.md)(agendaslotDao: [AgendaslotDao](../../com.example.achillesziekenhuis.data.database/-agendaslot-dao/index.md), agendaslotApiService: [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AgendaslotRepository](../-agendaslot-repository/index.md)

Concrete implementation of the [AgendaslotRepository](../-agendaslot-repository/index.md) interface. This class is responsible for fetching agendaslots from the network and storing them on disk.

## Constructors

| | |
|---|---|
| [CachingAgendaslotRepository](-caching-agendaslot-repository.md) | [androidJvm]<br>constructor(agendaslotDao: [AgendaslotDao](../../com.example.achillesziekenhuis.data.database/-agendaslot-dao/index.md), agendaslotApiService: [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>open override var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [getByRizivAndDate](get-by-riziv-and-date.md) | [androidJvm]<br>open override fun [getByRizivAndDate](get-by-riziv-and-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)&gt;&gt;<br>Returns the agendaslots of a doctor with a given riziv number and date. |
| [getByRRN](get-by-r-r-n.md) | [androidJvm]<br>open override fun [getByRRN](get-by-r-r-n.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)&gt;&gt;<br>Returns the agendaslots of a patient with a given National Insureance number (rijksregisternummer). |
| [getDailyAgendaslots](get-daily-agendaslots.md) | [androidJvm]<br>open override fun [getDailyAgendaslots](get-daily-agendaslots.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ListAgendaslot](../../com.example.achillesziekenhuis.model/-list-agendaslot/index.md)&gt;&gt;<br>Returns the start time of all available agendaslots per day. |
| [insertAgendaslot](insert-agendaslot.md) | [androidJvm]<br>open suspend override fun [insertAgendaslot](insert-agendaslot.md)(agendaslot: [ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md))<br>Inserts an agendaslot into the database. |
