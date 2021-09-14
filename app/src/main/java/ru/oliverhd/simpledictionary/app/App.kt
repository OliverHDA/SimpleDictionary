package ru.oliverhd.simpledictionary.app

import android.app.Application
import ru.oliverhd.simpledictionary.datasource.RemoteDataSource
import ru.oliverhd.simpledictionary.datasource.RemoteDataSourceImpl
import ru.oliverhd.simpledictionary.datasource.retrofit.RetrofitFactory
import ru.oliverhd.simpledictionary.presenter.MainPresenter
import ru.oliverhd.simpledictionary.presenter.Presenter
import ru.oliverhd.simpledictionary.repository.Repository
import ru.oliverhd.simpledictionary.repository.RepositoryImpl
import ru.oliverhd.simpledictionary.scheduler.DefaultSchedulers
import ru.oliverhd.simpledictionary.scheduler.Schedulers

class App : Application() {

    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var repository: Repository
    private lateinit var schedulers: Schedulers
    lateinit var mainPresenter: Presenter

    override fun onCreate() {
        super.onCreate()
        instance = this
        remoteDataSource = RemoteDataSourceImpl(RetrofitFactory.create())
        repository = RepositoryImpl(remoteDataSource)
        schedulers = DefaultSchedulers()
        mainPresenter = MainPresenter(repository, schedulers)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}