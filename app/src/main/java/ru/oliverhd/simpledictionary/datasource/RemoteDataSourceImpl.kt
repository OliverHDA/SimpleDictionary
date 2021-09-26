package ru.oliverhd.simpledictionary.datasource

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation
import ru.oliverhd.simpledictionary.datasource.retrofit.TranslateApi

class RemoteDataSourceImpl(private val translateApi: TranslateApi) :
    RemoteDataSource {

    override fun getTranslation(query: String): Single<Translation> =
        translateApi.getTranslation(
            "translated-mymemory---translation-memory.p.rapidapi.com",
            "46580dd2c8msh52e99d9dbd64f7ep17fa84jsn43f6978fbc4f",
            query,
            "en|ru"
        )
}