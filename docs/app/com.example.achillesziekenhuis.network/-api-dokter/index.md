//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[ApiDokter](index.md)

# ApiDokter

[androidJvm]\
@Serializable

data class [ApiDokter](index.md)(var riziv_nummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, var telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data class that represents a [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md) from the API.

## Constructors

| | |
|---|---|
| [ApiDokter](-api-dokter.md) | [androidJvm]<br>constructor(riziv_nummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [afdeling](afdeling.md) | [androidJvm]<br>var [afdeling](afdeling.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The department of the dokter. |
| [email](email.md) | [androidJvm]<br>var [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The email address of the dokter. |
| [familienaam](familienaam.md) | [androidJvm]<br>var [familienaam](familienaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The last name of the dokter. |
| [riziv_nummer](riziv_nummer.md) | [androidJvm]<br>var [riziv_nummer](riziv_nummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The riziv number of the dokter. |
| [telefoonnummer](telefoonnummer.md) | [androidJvm]<br>var [telefoonnummer](telefoonnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The phone number of the dokter. |
| [voornaam](voornaam.md) | [androidJvm]<br>var [voornaam](voornaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The first name of the dokter. |

## Functions

| Name | Summary |
|---|---|
| [asDomainListAgendaslot](../as-domain-list-agendaslot.md) | [androidJvm]<br>fun [ApiDokter](index.md).[asDomainListAgendaslot](../as-domain-list-agendaslot.md)(): [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)<br>Extension function that converts an [ApiDokter](index.md) to a [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md). |
