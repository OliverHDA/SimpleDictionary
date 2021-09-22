package ru.oliverhd.simpledictionary.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.simpledictionary.repository.Repository
import ru.oliverhd.simpledictionary.repository.RepositoryImpl
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository
}