package com.developer.allef.kotlincoroutines.di

import com.developer.allef.kotlincoroutines.BuildConfig
import com.developer.allef.kotlincoroutines.data.serviceApi
import com.developer.allef.kotlincoroutines.repository.CharacterRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author allef.santos on 2019-09-03
 */
val myModule = module {

    factory { providesOkHttpClient() }
    factory { CharacterRepository(serviceApi = get()) }

    single { createWebService<serviceApi>(
        okHttpClient = get(),
        url = "https://rickandmortyapi.com/"
    ) }

}
fun providesOkHttpClient(): OkHttpClient {
    val loggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}