package ru.oliverhd.simpledictionary.datasource

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation

interface RemoteDataSource {

    fun getTranslation(query: String): Single<Translation>
}