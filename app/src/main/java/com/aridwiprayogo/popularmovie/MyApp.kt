package com.aridwiprayogo.popularmovie

import android.app.Application
import com.aridwiprayogo.popularmovie.di.appModule
import com.aridwiprayogo.popularmovie.di.dataModule
import com.aridwiprayogo.popularmovie.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApp)
            modules(listOf(
                appModule,
                dataModule,
                presentationModule
            ))
        }
    }
}