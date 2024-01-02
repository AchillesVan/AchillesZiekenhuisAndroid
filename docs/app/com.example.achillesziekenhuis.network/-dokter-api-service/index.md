//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[DokterApiService](index.md)

# DokterApiService

interface [DokterApiService](index.md)

API communication interface for the [ApiDokter](../-api-dokter/index.md) endpoints.

#### Inheritors

| |
|---|
| [FakeApiDoktersService](../../com.example.achillesziekenhuis.fake/-fake-api-dokters-service/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getAfdelingen](get-afdelingen.md) | [androidJvm]<br>@GET(value = &quot;dokters/afdelingen&quot;)<br>abstract suspend fun [getAfdelingen](get-afdelingen.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>Returns a list of all available afdelingen. |
| [getAfdelingenAsFlow](../get-afdelingen-as-flow.md) | [androidJvm]<br>fun [DokterApiService](index.md).[getAfdelingenAsFlow](../get-afdelingen-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;&gt;<br>Extension function to get the afdelingen as a flow. |
| [getDokterByRiziv](get-dokter-by-riziv.md) | [androidJvm]<br>@GET(value = &quot;dokters/riziv/{rizivNummer}&quot;)<br>abstract suspend fun [getDokterByRiziv](get-dokter-by-riziv.md)(@Path(value = &quot;rizivNummer&quot;)rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ApiDokter](../-api-dokter/index.md)<br>Returns a dokter with a given riziv number. |
| [getDokterByRizivAsFlow](../get-dokter-by-riziv-as-flow.md) | [androidJvm]<br>fun [DokterApiService](index.md).[getDokterByRizivAsFlow](../get-dokter-by-riziv-as-flow.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[ApiDokter](../-api-dokter/index.md)&gt;<br>Extension function to get the dokter as a flow. |
| [getDokters](get-dokters.md) | [androidJvm]<br>@GET(value = &quot;dokters&quot;)<br>abstract suspend fun [getDokters](get-dokters.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../-api-dokter/index.md)&gt;<br>Returns a list of all available dokters. |
| [getDoktersAsFlow](../get-dokters-as-flow.md) | [androidJvm]<br>fun [DokterApiService](index.md).[getDoktersAsFlow](../get-dokters-as-flow.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../-api-dokter/index.md)&gt;&gt;<br>Extension function to get the dokters as a flow. |
| [getDoktersByAfdeling](get-dokters-by-afdeling.md) | [androidJvm]<br>@GET(value = &quot;dokters/afdeling/{afdeling}&quot;)<br>abstract suspend fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(@Path(value = &quot;afdeling&quot;)afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../-api-dokter/index.md)&gt;<br>Returns a list of all available dokters of a given afdeling. |
| [getDoktersByAfdelingAsFlow](../get-dokters-by-afdeling-as-flow.md) | [androidJvm]<br>fun [DokterApiService](index.md).[getDoktersByAfdelingAsFlow](../get-dokters-by-afdeling-as-flow.md)(afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../-api-dokter/index.md)&gt;&gt;<br>Extension function to get the dokters as a flow. |
