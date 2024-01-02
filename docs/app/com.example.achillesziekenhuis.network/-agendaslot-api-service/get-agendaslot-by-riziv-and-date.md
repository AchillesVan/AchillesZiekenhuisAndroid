//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[AgendaslotApiService](index.md)/[getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md)

# getAgendaslotByRizivAndDate

[androidJvm]\

@GET(value = &quot;agendaslots/{date}/{riziv}&quot;)

abstract suspend fun [getAgendaslotByRizivAndDate](get-agendaslot-by-riziv-and-date.md)(@Path(value = &quot;date&quot;)date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Path(value = &quot;riziv&quot;)riziv: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;

Returns a list of all agendaslots of a doctor with a given riziv number and date.
