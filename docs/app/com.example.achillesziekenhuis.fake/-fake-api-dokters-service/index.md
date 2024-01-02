//[app](../../../index.md)/[com.example.achillesziekenhuis.fake](../index.md)/[FakeApiDoktersService](index.md)

# FakeApiDoktersService

[androidJvm]\
class [FakeApiDoktersService](index.md) : [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md)

Fake implementation of [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md) for testing.

## Constructors

| | |
|---|---|
| [FakeApiDoktersService](-fake-api-dokters-service.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getAfdelingen](get-afdelingen.md) | [androidJvm]<br>open suspend override fun [getAfdelingen](get-afdelingen.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Returns a list of all available afdelingen. |
| [getAfdelingenAsFlow](../../com.example.achillesziekenhuis.network/get-afdelingen-as-flow.md) | [androidJvm]<br>fun [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md).[getAfdelingenAsFlow](../../com.example.achillesziekenhuis.network/get-afdelingen-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;&gt;<br>Extension function to get the afdelingen as a flow. |
| [getDokterByRiziv](get-dokter-by-riziv.md) | [androidJvm]<br>open suspend override fun [getDokterByRiziv](get-dokter-by-riziv.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)<br>Returns a dokter with a given riziv number. |
| [getDokterByRizivAsFlow](../../com.example.achillesziekenhuis.network/get-dokter-by-riziv-as-flow.md) | [androidJvm]<br>fun [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md).[getDokterByRizivAsFlow](../../com.example.achillesziekenhuis.network/get-dokter-by-riziv-as-flow.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)&gt;<br>Extension function to get the dokter as a flow. |
| [getDokters](get-dokters.md) | [androidJvm]<br>open suspend override fun [getDokters](get-dokters.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)&gt;<br>Returns a list of all available dokters. |
| [getDoktersAsFlow](../../com.example.achillesziekenhuis.network/get-dokters-as-flow.md) | [androidJvm]<br>fun [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md).[getDoktersAsFlow](../../com.example.achillesziekenhuis.network/get-dokters-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)&gt;&gt;<br>Extension function to get the dokters as a flow. |
| [getDoktersByAfdeling](get-dokters-by-afdeling.md) | [androidJvm]<br>open suspend override fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)&gt;<br>Returns a list of all dokters of a specific afdeling. |
| [getDoktersByAfdelingAsFlow](../../com.example.achillesziekenhuis.network/get-dokters-by-afdeling-as-flow.md) | [androidJvm]<br>fun [DokterApiService](../../com.example.achillesziekenhuis.network/-dokter-api-service/index.md).[getDoktersByAfdelingAsFlow](../../com.example.achillesziekenhuis.network/get-dokters-by-afdeling-as-flow.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../../com.example.achillesziekenhuis.network/-api-dokter/index.md)&gt;&gt;<br>Extension function to get the dokters as a flow. |
