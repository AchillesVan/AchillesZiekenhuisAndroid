package com.example.achillesziekenhuis.data

import android.content.Context
import com.example.achillesziekenhuis.R
import com.example.achillesziekenhuis.data.database.DokterDb
import com.example.achillesziekenhuis.model.User
import com.example.achillesziekenhuis.network.AgendaslotApiService
import com.example.achillesziekenhuis.network.DokterApiService
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
    fun setBearerToken(token: String)
    fun setUser(user: User)
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val BASE_URL = context.getString(R.string.BASE_URL)
    private var bearerToken: String? = null
    private  var user: User? = null

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

    override fun setBearerToken(token: String) {
        this.bearerToken = token
    }

    override fun setUser(user: User) {
        this.user = user
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

            bearerToken?.let {
                requestBuilder.header("Authorization", "Bearer $it")
            }

            val request: Request = requestBuilder.build()
            return chain.proceed(request)
        }
    }
}
