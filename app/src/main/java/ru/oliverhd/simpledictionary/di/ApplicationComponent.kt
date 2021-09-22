package ru.oliverhd.simpledictionary.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.oliverhd.simpledictionary.app.App
import ru.oliverhd.simpledictionary.di.modules.*
import ru.oliverhd.simpledictionary.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContributesAndroidInjectorModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        InteractorModule::class,
        TranslateApiModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }
}