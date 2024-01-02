//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[DbAgendaslot](index.md)

# DbAgendaslot

[androidJvm]\
data class [DbAgendaslot](index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val startTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val eindTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Database entities go in this file. These are responsible for reading and writing from the database.

## Constructors

| | |
|---|---|
| [DbAgendaslot](-db-agendaslot.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, startTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, eindTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [eindTijd](eind-tijd.md) | [androidJvm]<br>val [eindTijd](eind-tijd.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the end time of the agenda slot. |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>This is an auto generated id for the agenda slot. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>val [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the National Insurance number (rijksregisternummer) of the patient. |
| [rizivNummer](riziv-nummer.md) | [androidJvm]<br>val [rizivNummer](riziv-nummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the riziv number of the doctor. |
| [startTijd](start-tijd.md) | [androidJvm]<br>val [startTijd](start-tijd.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the start time of the agenda slot. |

## Functions

| Name | Summary |
|---|---|
| [asDomainAgendaslot](../as-domain-agendaslot.md) | [androidJvm]<br>fun [DbAgendaslot](index.md).[asDomainAgendaslot](../as-domain-agendaslot.md)(): [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md)<br>Map [DbAgendaslot](index.md) to domain entity [Agendaslot](../../com.example.achillesziekenhuis.model/-agendaslot/index.md) |
