package ru.oliverhd.simpledictionary.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.oliverhd.simpledictionary.datasource.RemoteDataSource
import ru.oliverhd.simpledictionary.datasource.RemoteDataSourceImpl
import ru.oliverhd.simpledictionary.datasource.retrofit.TranslateApi
import ru.oliverhd.simpledictionary.interactor.MainInteractor
import ru.oliverhd.simpledictionary.interactor.MainInteractorImpl
import ru.oliverhd.simpledictionary.repository.Repository
import ru.oliverhd.simpledictionary.repository.RepositoryImpl
import ru.oliverhd.simpledictionary.scheduler.DefaultSchedulers
import ru.oliverhd.simpledictionary.scheduler.Schedulers
import ru.oliverhd.simpledictionary.viewmodel.MainActivityViewModel

object Di {

    fun createModule() = module {
        single<TranslateApi> {
            Retrofit.Builder()
                .baseUrl("https://translated-mymemory---translation-memory.p.rapidapi.com/api/")
                .addConverterFactory(
                    GsonConverterFactory.create(GsonBuilder().setLenient().create())
                )
                .client(
                    OkHttpClient
                        .Builder()
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(TranslateApi::class.java)
        }
        single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
        single<Repository> { (RepositoryImpl(get())) }
        single<MainInteractor> { MainInteractorImpl(get()) }
        single<Schedulers> { DefaultSchedulers() }
        viewModel {
            MainActivityViewModel(
                interactor = get(),
                schedulers = get()
            )
        }
    }
}