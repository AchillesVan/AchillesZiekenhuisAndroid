//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[ApiAgendaslot](index.md)

# ApiAgendaslot

[androidJvm]\
@Serializable

data class [ApiAgendaslot](index.md)(var id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, var riziv_nummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var start_tijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var eind_tijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Data class that represents an [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md) from the API.

## Constructors

| | |
|---|---|
| [ApiAgendaslot](-api-agendaslot.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, riziv_nummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, start_tijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, eind_tijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [eind_tijd](eind_tijd.md) | [androidJvm]<br>var [eind_tijd](eind_tijd.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The end time of the agendaslot. |
| [id](id.md) | [androidJvm]<br>var [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Unique identifier for the agendaslot. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>var [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The National Insurance number (rijksregisternummer) of the patient. |
| [riziv_nummer](riziv_nummer.md) | [androidJvm]<br>var [riziv_nummer](riziv_nummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The riziv number of the doctor. |
| [start_tijd](start_tijd.md) | [androidJvm]<br>var [start_tijd](start_tijd.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The start time of the agendaslot. |

## Functions

| Name | Summary |
|---|---|
| [asDomainAgendaslot](../as-domain-agendaslot.md) | [androidJvm]<br>fun [ApiAgendaslot](index.md).[asDomainAgendaslot](../as-domain-agendaslot.md)(): [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)<br>Represents an [ApiAgendaslot](index.md) as an [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md). |
