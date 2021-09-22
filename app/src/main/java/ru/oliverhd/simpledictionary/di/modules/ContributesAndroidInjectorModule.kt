package ru.oliverhd.simpledictionary.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.oliverhd.simpledictionary.view.MainActivity
import ru.oliverhd.simpledictionary.viewmodel.MainActivityViewModel

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}