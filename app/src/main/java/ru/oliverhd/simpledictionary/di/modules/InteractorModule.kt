package ru.oliverhd.simpledictionary.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.simpledictionary.interactor.MainInteractor
import ru.oliverhd.simpledictionary.interactor.MainInteractorImpl
import javax.inject.Singleton

@Module
interface InteractorModule {

    @Singleton
    @Binds
    fun bindInteractor(interactor: MainInteractorImpl): MainInteractor
}