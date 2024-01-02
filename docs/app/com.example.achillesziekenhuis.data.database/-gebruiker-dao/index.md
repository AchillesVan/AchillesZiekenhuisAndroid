//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[GebruikerDao](index.md)

# GebruikerDao

[androidJvm]\
interface [GebruikerDao](index.md)

Database entities go in this file. These are responsible for reading and writing from the database.

## Functions

| Name | Summary |
|---|---|
| [getAllGebruikers](get-all-gebruikers.md) | [androidJvm]<br>abstract fun [getAllGebruikers](get-all-gebruikers.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbGebruiker](../-db-gebruiker/index.md)&gt;&gt;<br>Select all gebruikers from the gebruikers table. |
| [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md) | [androidJvm]<br>abstract fun [getGebruikerByAuth0id](get-gebruiker-by-auth0id.md)(auth0id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DbGebruiker](../-db-gebruiker/index.md)&gt;<br>Select a gebruiker by their auth0id. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DbGebruiker](../-db-gebruiker/index.md))<br>Insert a gebruiker in the database. If the gebruiker already exists, ignore it. |
