package com.example.achillesziekenhuis.data

import android.content.Context
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.data.database.DokterDb
import com.example.achillesziekenhuis.model.Auth0User
import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.DokterApiService
import com.example.achillesziekenhuis.network.GebruikerApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit

interface AppContainer {
    val doktersRepository: DoktersRepository
    val agendaslotRepository: AgendaslotRepository
    val gebruikersRepository: GebruikersRepository
    fun setUser(auth0User: Auth0User)
    fun getAuth0Id(): String
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val BASE_URL = context.getString(R.string.BASE_URL)
    private  var auth0User: Auth0User? = null

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(BASE_URL)
        .client(createOkHttpClient())
        .build()

    private val retrofitDokterService: DokterApiService by lazy {
        retrofit.create(DokterApiService::class.java)
    }

    private val retrofitAgendaslotService: AgendaslotApiService by lazy {
        retrofit.create(AgendaslotApiService::class.java)
    }

    private val retrofitGebruikerService: GebruikerApiService by lazy {
        retrofit.create(GebruikerApiService::class.java)
    }

    override val doktersRepository: DoktersRepository by lazy {
        CachingDokterRepository(
            DokterDb.getDatabase(context = context).dokterDao(),
            retrofitDokterService,
            context,
        )
    }

    override val agendaslotRepository: AgendaslotRepository by lazy {
        CachingAgendaslotRepository(
            DokterDb.getDatabase(context = context).agendaslotDao(),
            retrofitAgendaslotService,
            context,
        )
    }

    override val gebruikersRepository: GebruikersRepository by lazy {
        CachingGebruikersRepository(
            DokterDb.getDatabase(context = context).gebruikerDao(),
            retrofitGebruikerService,
            context,
        )
    }

    override fun setUser(auth0User: Auth0User) {
        this.auth0User = auth0User
    }

    override fun getAuth0Id(): String {
        return auth0User?.id.toString()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(BearerInterceptor())
            .build()
    }

    private inner class BearerInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()

            auth0User?.idToken.let {
                requestBuilder.header("Authorization", "Bearer $it")
            }

            val request: Request = requestBuilder.build()
            return chain.proceed(request)
        }
    }
}
