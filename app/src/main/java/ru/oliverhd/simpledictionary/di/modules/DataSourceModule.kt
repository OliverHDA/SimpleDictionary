package ru.oliverhd.simpledictionary.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.simpledictionary.datasource.RemoteDataSource
import ru.oliverhd.simpledictionary.datasource.RemoteDataSourceImpl
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindRemoteDataSource(dataSource: RemoteDataSourceImpl): RemoteDataSource
}