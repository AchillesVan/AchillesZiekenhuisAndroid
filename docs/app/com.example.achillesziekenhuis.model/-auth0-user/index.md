//[app](../../../index.md)/[com.example.achillesziekenhuis.model](../index.md)/[Auth0User](index.md)

# Auth0User

[androidJvm]\
data class [Auth0User](index.md)(val idToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

Data class that represents an Auth0 user.

## Constructors

| | |
|---|---|
| [Auth0User](-auth0-user.md) | [androidJvm]<br>constructor(idToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [email](email.md) | [androidJvm]<br>var [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The user's email address. |
| [emailVerified](email-verified.md) | [androidJvm]<br>var [emailVerified](email-verified.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Whether the user's email address has been verified. |
| [id](id.md) | [androidJvm]<br>var [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The user's ID. |
| [idToken](id-token.md) | [androidJvm]<br>val [idToken](id-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The JWT that represents the user. |
| [name](name.md) | [androidJvm]<br>var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The user's name. |
| [picture](picture.md) | [androidJvm]<br>var [picture](picture.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The URL of the user's profile picture. |
| [updatedAt](updated-at.md) | [androidJvm]<br>var [updatedAt](updated-at.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The time the user's profile was last updated. |

## Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | [androidJvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
