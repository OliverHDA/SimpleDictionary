package ru.oliverhd.simpledictionary.repository

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation
import ru.oliverhd.simpledictionary.datasource.RemoteDataSource

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {

    override fun getTranslation(query: String): Single<Translation> =
        remoteDataSource.getTranslation(query)
}