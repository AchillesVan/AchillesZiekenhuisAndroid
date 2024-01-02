//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[DokterApiService](index.md)/[getDoktersByAfdeling](get-dokters-by-afdeling.md)

# getDoktersByAfdeling

[androidJvm]\

@GET(value = &quot;dokters/afdeling/{afdeling}&quot;)

abstract suspend fun [getDoktersByAfdeling](get-dokters-by-afdeling.md)(@Path(value = &quot;afdeling&quot;)afdeling: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ApiDokter](../-api-dokter/index.md)&gt;

Returns a list of all available dokters of a given afdeling.
