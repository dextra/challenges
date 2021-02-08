package dev.dextra.newsapp

import android.app.Application
import dev.dextra.newsapp.base.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //configure and start Koin
        startKoin {
            androidContext(this@NewsApplication)
            modules(appComponent)
        }
    }
}