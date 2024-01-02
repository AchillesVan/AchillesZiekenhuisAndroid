//[app](../../../index.md)/[com.example.achillesziekenhuis.fake](../index.md)/[FakeApiAgendaslotService](index.md)

# FakeApiAgendaslotService

[androidJvm]\
class [FakeApiAgendaslotService](index.md) : [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md)

Fake implementation of [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md) for testing.

## Constructors

| | |
|---|---|
| [FakeApiAgendaslotService](-fake-api-agendaslot-service.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md) | [androidJvm]<br>open suspend override fun [getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), riziv: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md)&gt;<br>Returns a list of all agendaslots of a doctor with a given riziv number and date. |
| [getAgendaslotByRizivAndDateAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslot-by-riziv-and-date-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md).[getAgendaslotByRizivAndDateAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslot-by-riziv-and-date-as-flow.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md) | [androidJvm]<br>open suspend override fun [getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md)&gt;<br>Returns a list of all agendaslots of a patient with a given National Insurance number (rijksregisternummer). |
| [getAgendaslotsByRRNAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslots-by-r-r-n-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md).[getAgendaslotsByRRNAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslots-by-r-r-n-as-flow.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [getAgendaslotsDaily](get-agendaslots-daily.md) | [androidJvm]<br>open suspend override fun [getAgendaslotsDaily](get-agendaslots-daily.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiListAgendaslot](../../com.example.achillesziekenhuis.network/-api-list-agendaslot/index.md)&gt;<br>Returns a list of all available agendaslots per day. |
| [getAgendaslotsDailyAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslots-daily-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](../../com.example.achillesziekenhuis.network/-agendaslot-api-service/index.md).[getAgendaslotsDailyAsFlow](../../com.example.achillesziekenhuis.network/get-agendaslots-daily-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiListAgendaslot](../../com.example.achillesziekenhuis.network/-api-list-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [postAgendaslot](post-agendaslot.md) | [androidJvm]<br>open suspend override fun [postAgendaslot](post-agendaslot.md)(agendaslot: [ApiAgendaslot](../../com.example.achillesziekenhuis.network/-api-agendaslot/index.md)): Response&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Inserts an agendaslot into the database. |
