package ru.oliverhd.simpledictionary.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.oliverhd.simpledictionary.di.ApplicationComponent
import ru.oliverhd.simpledictionary.di.DaggerApplicationComponent
import ru.oliverhd.simpledictionary.scheduler.DefaultSchedulers

class App : DaggerApplication() {

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                withSchedulers(DefaultSchedulers())
            }
            .build()
    }

    override fun applicationInjector(): AndroidInjector<App> =
        applicationComponent
}