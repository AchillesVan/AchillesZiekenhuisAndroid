//[app](../../../index.md)/[com.example.achillesziekenhuis.model](../index.md)/[Agendaslot](index.md)

# Agendaslot

[androidJvm]\
class [Agendaslot](index.md)(var id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, var rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var startTijd: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html) = LocalDateTime.now())

Data class that represents an agendaslot.

## Constructors

| | |
|---|---|
| [Agendaslot](-agendaslot.md) | [androidJvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, startTijd: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html) = LocalDateTime.now()) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>var [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Unique identifier for the agendaslot. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>var [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The National Insurance number (rijksregisternummer) of the patient. |
| [rizivNummer](riziv-nummer.md) | [androidJvm]<br>var [rizivNummer](riziv-nummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The riziv number of the doctor. |
| [startTijd](start-tijd.md) | [androidJvm]<br>var [startTijd](start-tijd.md): [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html)<br>The start time of the agendaslot. |

## Functions

| Name | Summary |
|---|---|
| [asDbAgendaslot](../../com.example.achillesziekenhuis.data.database/as-db-agendaslot.md) | [androidJvm]<br>fun [Agendaslot](index.md).[asDbAgendaslot](../../com.example.achillesziekenhuis.data.database/as-db-agendaslot.md)(): [DbAgendaslot](../../com.example.achillesziekenhuis.data.database/-db-agendaslot/index.md)<br>Map domain entity [Agendaslot](index.md) to database entities [DbAgendaslot](../../com.example.achillesziekenhuis.data.database/-db-agendaslot/index.md) |
