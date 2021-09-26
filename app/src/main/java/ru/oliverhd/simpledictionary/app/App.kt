package ru.oliverhd.simpledictionary.app

import android.app.Application
import org.koin.core.context.startKoin
import ru.oliverhd.simpledictionary.di.Di

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(Di.createModule())
        }
    }
}