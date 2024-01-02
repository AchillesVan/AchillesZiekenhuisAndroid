//[app](../../../index.md)/[com.example.achillesziekenhuis.model](../index.md)/[Dokter](index.md)

# Dokter

[androidJvm]\
data class [Dokter](index.md)(var rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data class that represents a dokter.

## Constructors

| | |
|---|---|
| [Dokter](-dokter.md) | [androidJvm]<br>constructor(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [afdeling](afdeling.md) | [androidJvm]<br>var [afdeling](afdeling.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The department of the dokter. |
| [email](email.md) | [androidJvm]<br>var [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The email address of the dokter. |
| [familienaam](familienaam.md) | [androidJvm]<br>var [familienaam](familienaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The last name of the dokter. |
| [rizivNummer](riziv-nummer.md) | [androidJvm]<br>var [rizivNummer](riziv-nummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The riziv number of the dokter. |
| [telefoonnummer](telefoonnummer.md) | [androidJvm]<br>var [telefoonnummer](telefoonnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The phone number of the dokter. |
| [voornaam](voornaam.md) | [androidJvm]<br>var [voornaam](voornaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The first name of the dokter. |

## Functions

| Name | Summary |
|---|---|
| [asApiDokter](../../com.example.achillesziekenhuis.network/as-api-dokter.md) | [androidJvm]<br>fun [Dokter](index.md).[asApiDokter](../../com.example.achillesziekenhuis.network/as-api-dokter.md)(): [ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)<br>Extension function that converts a [Dokter](index.md) to an [ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md). |
| [asDbDokter](../../com.example.achillesziekenhuis.data.database/as-db-dokter.md) | [androidJvm]<br>fun [Dokter](index.md).[asDbDokter](../../com.example.achillesziekenhuis.data.database/as-db-dokter.md)(): [DbDokter](../../com.example.achillesziekenhuis.data.database/-db-dokter/index.md)<br>Map domain entity [Dokter](index.md) to database entity [DbDokter](../../com.example.achillesziekenhuis.data.database/-db-dokter/index.md) |
| [toString](to-string.md) | [androidJvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
