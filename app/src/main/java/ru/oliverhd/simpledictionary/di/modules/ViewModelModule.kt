package ru.oliverhd.simpledictionary.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.oliverhd.simpledictionary.viewmodel.MainActivityViewModel
import ru.oliverhd.simpledictionary.viewmodel.ViewModelFactory
import ru.oliverhd.simpledictionary.viewmodel.ViewModelKey

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun mainViewModel(mainViewModel: MainActivityViewModel): ViewModel
}