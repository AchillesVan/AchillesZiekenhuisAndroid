//[app](../../../index.md)/[com.example.achillesziekenhuis.data](../index.md)/[DoktersRepository](index.md)

# DoktersRepository

interface [DoktersRepository](index.md)

Repository for fetching [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)s from the network and storing them on disk.

#### Inheritors

| |
|---|
| [CachingDokterRepository](../-caching-dokter-repository/index.md) |
| [FakeApiDokterRepository](../../com.example.achillesziekenhuis.fake/-fake-api-dokter-repository/index.md) |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>abstract var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [deleteDokter](delete-dokter.md) | [androidJvm]<br>abstract suspend fun [deleteDokter](delete-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Deletes a dokter from the database. |
| [getAfdelingen](get-afdelingen.md) | [androidJvm]<br>abstract fun [getAfdelingen](get-afdelingen.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;&gt;<br>Returns all afdelingen from the database. |
| [getDokters](get-dokters.md) | [androidJvm]<br>abstract fun [getDokters](get-dokters.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)&gt;&gt;<br>Returns all dokters from the database. |
| [getDoktersByAfdeling](get-dokters-by-afdeling.md) | [androidJvm]<br>abstract fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)&gt;&gt;<br>Returns all dokters from a specific afdeling from the database. |
| [insertDokter](insert-dokter.md) | [androidJvm]<br>abstract suspend fun [insertDokter](insert-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Inserts a dokter into the database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)()<br>Refreshes the dokters in the database. |
| [updateDokter](update-dokter.md) | [androidJvm]<br>abstract suspend fun [updateDokter](update-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Updates a dokter in the database. |
