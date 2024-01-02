//[app](../../../index.md)/[com.example.achillesziekenhuis.fake](../index.md)/[FakeApiAgendaslotRepository](index.md)

# FakeApiAgendaslotRepository

[androidJvm]\
class [FakeApiAgendaslotRepository](index.md) : [AgendaslotRepository](../../com.example.achillesziekenhuis.data/-agendaslot-repository/index.md)

Fake implementation of [AgendaslotRepository](../../com.example.achillesziekenhuis.data/-agendaslot-repository/index.md) for testing.

## Constructors

| | |
|---|---|
| [FakeApiAgendaslotRepository](-fake-api-agendaslot-repository.md) | [androidJvm]<br>constructor() |

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
