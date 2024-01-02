//[app](../../../index.md)/[com.example.achillesziekenhuis.fake](../index.md)/[FakeApiDokterRepository](index.md)

# FakeApiDokterRepository

[androidJvm]\
class [FakeApiDokterRepository](index.md) : [DoktersRepository](../../com.example.achillesziekenhuis.data/-dokters-repository/index.md)

Fake implementation of [DoktersRepository](../../com.example.achillesziekenhuis.data/-dokters-repository/index.md) for testing.

## Constructors

| | |
|---|---|
| [FakeApiDokterRepository](-fake-api-dokter-repository.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [wifiWorkInfo](wifi-work-info.md) | [androidJvm]<br>open override var [wifiWorkInfo](wifi-work-info.md): Flow&lt;[WorkInfo](https://developer.android.com/reference/kotlin/androidx/work/WorkInfo.html)&gt;<br>Returns the work info of the wifi notification worker. |

## Functions

| Name | Summary |
|---|---|
| [deleteDokter](delete-dokter.md) | [androidJvm]<br>open suspend override fun [deleteDokter](delete-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Deletes a dokter from the database. |
| [getAfdelingen](get-afdelingen.md) | [androidJvm]<br>open override fun [getAfdelingen](get-afdelingen.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;&gt;<br>Returns all afdelingen from the database. |
| [getDokters](get-dokters.md) | [androidJvm]<br>open override fun [getDokters](get-dokters.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)&gt;&gt;<br>Returns all dokters from the database. |
| [getDoktersByAfdeling](get-dokters-by-afdeling.md) | [androidJvm]<br>open override fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md)&gt;&gt;<br>Returns all dokters from a specific afdeling from the database. |
| [insertDokter](insert-dokter.md) | [androidJvm]<br>open suspend override fun [insertDokter](insert-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Inserts a dokter into the database. |
| [refresh](refresh.md) | [androidJvm]<br>open suspend override fun [refresh](refresh.md)()<br>Refreshes the dokters in the database. |
| [updateDokter](update-dokter.md) | [androidJvm]<br>open suspend override fun [updateDokter](update-dokter.md)(dokter: [Dokter](../../com.example.achillesziekenhuis.model/-dokter/index.md))<br>Updates a dokter in the database. |
