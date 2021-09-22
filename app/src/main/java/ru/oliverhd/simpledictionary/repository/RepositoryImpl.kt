package ru.oliverhd.simpledictionary.repository

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation
import ru.oliverhd.simpledictionary.datasource.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    Repository {

    override fun getTranslation(query: String): Single<Translation> =
        remoteDataSource.getTranslation(query)
}