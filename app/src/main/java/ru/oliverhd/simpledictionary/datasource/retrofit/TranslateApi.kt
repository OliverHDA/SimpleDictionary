package ru.oliverhd.simpledictionary.datasource.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.oliverhd.simpledictionary.data.Translation

interface TranslateApi {

    @GET("get")
    fun getTranslation(
        @Header("X-RapidAPI-Host") host: String,
        @Header("X-RapidAPI-Key") key: String,
        @Query("q") query: String,
        @Query("langpair") langpair: String
    ): Single<Translation>
}