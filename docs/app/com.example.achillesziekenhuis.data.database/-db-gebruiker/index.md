//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[DbGebruiker](index.md)

# DbGebruiker

[androidJvm]\
data class [DbGebruiker](index.md)(val rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val optioneleAdreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Database entities go in this file. These are responsible for reading and writing from the database.

## Constructors

| | |
|---|---|
| [DbGebruiker](-db-gebruiker.md) | [androidJvm]<br>constructor(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, optioneleAdreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [auth0id](auth0id.md) | [androidJvm]<br>val [auth0id](auth0id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the auth0 id of the patient. |
| [email](email.md) | [androidJvm]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the email of the patient. |
| [familienaam](familienaam.md) | [androidJvm]<br>val [familienaam](familienaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the last name of the patient. |
| [geboortedatum](geboortedatum.md) | [androidJvm]<br>val [geboortedatum](geboortedatum.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the birth date of the patient. |
| [geboorteplaats](geboorteplaats.md) | [androidJvm]<br>val [geboorteplaats](geboorteplaats.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the birth place of the patient. |
| [gemeente](gemeente.md) | [androidJvm]<br>val [gemeente](gemeente.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the city of the patient. |
| [geslacht](geslacht.md) | [androidJvm]<br>val [geslacht](geslacht.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the gender of the patient. |
| [huisnummer](huisnummer.md) | [androidJvm]<br>val [huisnummer](huisnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the house number of the patient. |
| [land](land.md) | [androidJvm]<br>val [land](land.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the country of the patient. |
| [optioneleAdreslijn](optionele-adreslijn.md) | [androidJvm]<br>val [optioneleAdreslijn](optionele-adreslijn.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the optional address line of the patient. |
| [postcode](postcode.md) | [androidJvm]<br>val [postcode](postcode.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the postal code of the patient. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>val [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the National Insurance number (rijksregisternummer) of the patient. |
| [straat](straat.md) | [androidJvm]<br>val [straat](straat.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the street of the patient. |
| [telefoonnummer](telefoonnummer.md) | [androidJvm]<br>val [telefoonnummer](telefoonnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the phone number of the patient. |
| [voornaam](voornaam.md) | [androidJvm]<br>val [voornaam](voornaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This is the first name of the patient. |

## Functions

| Name | Summary |
|---|---|
| [asDomainGebruiker](../as-domain-gebruiker.md) | [androidJvm]<br>fun [DbGebruiker](index.md).[asDomainGebruiker](../as-domain-gebruiker.md)(): [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md)<br>Map database entity [DbGebruiker](index.md) to domain entity [Gebruiker](../../com.example.achillesziekenhuis.model/-gebruiker/index.md) |
