package ru.oliverhd.simpledictionary.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.oliverhd.simpledictionary.datasource.retrofit.TranslateApi
import javax.inject.Named

@Module
class TranslateApiModule {

    @Named("mymemory_base_url")
    @Provides
    fun provideBaseUrl(): String =
        "https://translated-mymemory---translation-memory.p.rapidapi.com/api/"

    @Provides
    fun provideTranslateApi(@Named("mymemory_base_url") baseUrl: String): TranslateApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
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