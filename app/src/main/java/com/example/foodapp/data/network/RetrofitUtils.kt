package com.example.foodapp.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtils {

    private const val BASE_URL = "https://www.themealdb.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun setUpApiKeyInterceptor(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder().addQueryParameter("API_key","1").build())
            .build()
    )

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .readTimeout(2000L, TimeUnit.MILLISECONDS)
                .addInterceptor { block -> setUpApiKeyInterceptor(block) }.build())
        .build()

    val appService : AppService = retrofit.create(AppService::class.java)
}