package edu.pe.idat.appretrofittotalkotlin.retrofit

import edu.pe.idat.appretrofittotalkotlin.common.Constantes
import edu.pe.idat.appretrofittotalkotlin.retrofit.api.ApiPersonajeService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitCliente {

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        //.addInterceptor(ApiInterceptor()) Para el uso de JWT
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(Constantes.URL_BASE_API)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitServicio: ApiPersonajeService by lazy {
        buildRetrofit().create(ApiPersonajeService::class.java)
    }
}