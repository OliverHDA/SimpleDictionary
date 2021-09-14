package ru.oliverhd.simpledictionary.datasource.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun create(): TranslateApi =
        Retrofit.Builder()
            .baseUrl("https://translated-mymemory---translation-memory.p.rapidapi.com/api/")
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(TranslateApi::class.java)
}