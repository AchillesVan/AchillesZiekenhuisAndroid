//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[AgendaslotApiService](index.md)

# AgendaslotApiService

interface [AgendaslotApiService](index.md)

API communication interface for the [ApiAgendaslot](../-api-agendaslot/index.md) endpoints.

#### Inheritors

| |
|---|
| [FakeApiAgendaslotService](../../com.example.achillesziekenhuis.fake/-fake-api-agendaslot-service/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md) | [androidJvm]<br>@GET(value = &quot;agendaslots/{date}/{riziv}&quot;)<br>abstract suspend fun [getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md)(@Path(value = &quot;date&quot;)date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Path(value = &quot;riziv&quot;)riziv: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;<br>Returns a list of all agendaslots of a doctor with a given riziv number and date. |
| [getAgendaslotByRizivAndDateAsFlow](../get-agendaslot-by-riziv-and-date-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](index.md).[getAgendaslotByRizivAndDateAsFlow](../get-agendaslot-by-riziv-and-date-as-flow.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md) | [androidJvm]<br>@GET(value = &quot;agendaslots/rrn/{rijksregisternummer}&quot;)<br>abstract suspend fun [getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md)(@Path(value = &quot;rijksregisternummer&quot;)rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;<br>Returns a list of all agendaslots of a patient with a given National Insurance number (rijksregisternummer). |
| [getAgendaslotsByRRNAsFlow](../get-agendaslots-by-r-r-n-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](index.md).[getAgendaslotsByRRNAsFlow](../get-agendaslots-by-r-r-n-as-flow.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [getAgendaslotsDaily](get-agendaslots-daily.md) | [androidJvm]<br>@GET(value = &quot;agendaslots/daily&quot;)<br>abstract suspend fun [getAgendaslotsDaily](get-agendaslots-daily.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiListAgendaslot](../-api-list-agendaslot/index.md)&gt;<br>Returns a list of all available agendaslots per day. |
| [getAgendaslotsDailyAsFlow](../get-agendaslots-daily-as-flow.md) | [androidJvm]<br>fun [AgendaslotApiService](index.md).[getAgendaslotsDailyAsFlow](../get-agendaslots-daily-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiListAgendaslot](../-api-list-agendaslot/index.md)&gt;&gt;<br>Extension function to get the agendaslots as a flow. |
| [postAgendaslot](post-agendaslot.md) | [androidJvm]<br>@POST(value = &quot;agendaslots&quot;)<br>abstract suspend fun [postAgendaslot](post-agendaslot.md)(@Bodyagendaslot: [ApiAgendaslot](../-api-agendaslot/index.md)): Response&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;<br>Inserts an agendaslot into the database. |
