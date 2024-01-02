//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[ApiGebruiker](index.md)

# ApiGebruiker

[androidJvm]\
@Serializable

data class [ApiGebruiker](index.md)(val rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val optionele_adreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Data class that represents a [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md) from the API.

## Constructors

| | |
|---|---|
| [ApiGebruiker](-api-gebruiker.md) | [androidJvm]<br>constructor(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, optionele_adreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [auth0id](auth0id.md) | [androidJvm]<br>val [auth0id](auth0id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The auth0 id of the patient. |
| [email](email.md) | [androidJvm]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The email address of the patient. |
| [familienaam](familienaam.md) | [androidJvm]<br>val [familienaam](familienaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The last name of the patient. |
| [geboortedatum](geboortedatum.md) | [androidJvm]<br>val [geboortedatum](geboortedatum.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The date of birth of the patient. |
| [geboorteplaats](geboorteplaats.md) | [androidJvm]<br>val [geboorteplaats](geboorteplaats.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The place of birth of the patient. |
| [gemeente](gemeente.md) | [androidJvm]<br>val [gemeente](gemeente.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The city of the patient. |
| [geslacht](geslacht.md) | [androidJvm]<br>val [geslacht](geslacht.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The gender of the patient. |
| [huisnummer](huisnummer.md) | [androidJvm]<br>val [huisnummer](huisnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The house number of the patient. |
| [land](land.md) | [androidJvm]<br>val [land](land.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The country of the patient. |
| [optionele_adreslijn](optionele_adreslijn.md) | [androidJvm]<br>val [optionele_adreslijn](optionele_adreslijn.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The optional address line of the patient. |
| [postcode](postcode.md) | [androidJvm]<br>val [postcode](postcode.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The postal code of the patient. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>val [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The National Insurance number (rijksregisternummer) of the patient. |
| [straat](straat.md) | [androidJvm]<br>val [straat](straat.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The street of the patient. |
| [telefoonnummer](telefoonnummer.md) | [androidJvm]<br>val [telefoonnummer](telefoonnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The phone number of the patient. |
| [voornaam](voornaam.md) | [androidJvm]<br>val [voornaam](voornaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The first name of the patient. |

## Functions

| Name | Summary |
|---|---|
| [asDomainListAgendaslot](../as-domain-list-agendaslot.md) | [androidJvm]<br>fun [ApiGebruiker](index.md).[asDomainListAgendaslot](../as-domain-list-agendaslot.md)(): [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)<br>Extension function that converts an [ApiGebruiker](index.md) to a [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md). |
