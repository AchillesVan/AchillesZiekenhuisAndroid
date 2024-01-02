//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[DokterDao](index.md)

# DokterDao

[androidJvm]\
interface [DokterDao](index.md)

Database entities go in this file. These are responsible for reading and writing from the database.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DbDokter](../-db-dokter/index.md))<br>Delete a dokter. |
| [getAfdelingen](get-afdelingen.md) | [androidJvm]<br>abstract fun [getAfdelingen](get-afdelingen.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;&gt;<br>Select the distinct departments of all doctors |
| [getAllDokters](get-all-dokters.md) | [androidJvm]<br>abstract fun [getAllDokters](get-all-dokters.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbDokter](../-db-dokter/index.md)&gt;&gt;<br>Select all dokters from the dokters table ordered by their last name. |
| [getDoktersByAfdeling](get-dokters-by-afdeling.md) | [androidJvm]<br>abstract fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbDokter](../-db-dokter/index.md)&gt;&gt;<br>Select all doctors from a specific department |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DbDokter](../-db-dokter/index.md))<br>Insert a dokter in the database. If the dokter already exists, ignore it. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [DbDokter](../-db-dokter/index.md))<br>Update a dokter. |
