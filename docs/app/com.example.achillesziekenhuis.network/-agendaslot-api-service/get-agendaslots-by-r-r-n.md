//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[AgendaslotApiService](index.md)/[getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md)

# getAgendaslotsByRRN

[androidJvm]\

@GET(value = &quot;agendaslots/rrn/{rijksregisternummer}&quot;)

abstract suspend fun [getAgendaslotsByRRN](get-agendaslots-by-r-r-n.md)(@Path(value = &quot;rijksregisternummer&quot;)rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiAgendaslot](../-api-agendaslot/index.md)&gt;

Returns a list of all agendaslots of a patient with a given National Insurance number (rijksregisternummer).
