//[app](../../../index.md)/[com.example.achillesziekenhuis.network](../index.md)/[DokterApiService](index.md)/[getDokterByRiziv](get-dokter-by-riziv.md)

# getDokterByRiziv

[androidJvm]\

@GET(value = &quot;dokters/riziv/{rizivNummer}&quot;)

abstract suspend fun [getDokterByRiziv](get-dokter-by-riziv.md)(@Path(value = &quot;rizivNummer&quot;)rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ApiDokter](../-api-dokter/index.md)

Returns a dokter with a given riziv number.
