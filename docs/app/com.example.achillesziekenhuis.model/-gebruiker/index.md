//[app](../../../index.md)/[com.example.achillesziekenhuis.model](../index.md)/[Gebruiker](index.md)

# Gebruiker

[androidJvm]\
data class [Gebruiker](index.md)(val rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val optioneleAdreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Data class that represents a user.

## Constructors

| | |
|---|---|
| [Gebruiker](-gebruiker.md) | [androidJvm]<br>constructor(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, voornaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, familienaam: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geslacht: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboortedatum: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, geboorteplaats: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, telefoonnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, straat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, huisnummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, optioneleAdreslijn: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, postcode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, gemeente: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, land: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [auth0id](auth0id.md) | [androidJvm]<br>val [auth0id](auth0id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The Auth0 ID of the user. |
| [email](email.md) | [androidJvm]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The email address of the user. |
| [familienaam](familienaam.md) | [androidJvm]<br>val [familienaam](familienaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The last name of the user. |
| [geboortedatum](geboortedatum.md) | [androidJvm]<br>val [geboortedatum](geboortedatum.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The date of birth of the user. |
| [geboorteplaats](geboorteplaats.md) | [androidJvm]<br>val [geboorteplaats](geboorteplaats.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The place of birth of the user. |
| [gemeente](gemeente.md) | [androidJvm]<br>val [gemeente](gemeente.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The city of the user. |
| [geslacht](geslacht.md) | [androidJvm]<br>val [geslacht](geslacht.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The gender of the user. |
| [huisnummer](huisnummer.md) | [androidJvm]<br>val [huisnummer](huisnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The house number of the user. |
| [land](land.md) | [androidJvm]<br>val [land](land.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The country of the user. |
| [optioneleAdreslijn](optionele-adreslijn.md) | [androidJvm]<br>val [optioneleAdreslijn](optionele-adreslijn.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The optional address line of the user. |
| [postcode](postcode.md) | [androidJvm]<br>val [postcode](postcode.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The postal code of the user. |
| [rijksregisternummer](rijksregisternummer.md) | [androidJvm]<br>val [rijksregisternummer](rijksregisternummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The National Insurance number (rijksregisternummer) of the user. |
| [straat](straat.md) | [androidJvm]<br>val [straat](straat.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The street of the user. |
| [telefoonnummer](telefoonnummer.md) | [androidJvm]<br>val [telefoonnummer](telefoonnummer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The phone number of the user. |
| [voornaam](voornaam.md) | [androidJvm]<br>val [voornaam](voornaam.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The first name of the user. |

## Functions

| Name | Summary |
|---|---|
| [asDbGebruiker](../../com.example.achillesziekenhuis.data.database/as-db-gebruiker.md) | [androidJvm]<br>fun [Gebruiker](index.md).[asDbGebruiker](../../com.example.achillesziekenhuis.data.database/as-db-gebruiker.md)(): [DbGebruiker](../../com.example.achillesziekenhuis.data.database/-db-gebruiker/index.md)<br>Map domain entity [Gebruiker](index.md) to database entity [DbGebruiker](../../com.example.achillesziekenhuis.data.database/-db-gebruiker/index.md) |
