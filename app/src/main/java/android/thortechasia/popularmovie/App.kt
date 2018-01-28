package android.thortechasia.popularmovie

import android.thortechasia.popularmovie.di.*
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : DaggerApplication(){
    private val appComponent: AndroidInjector<App> by lazy {
        DaggerAppComponent
            .builder()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(networkModule, dataModule,
            presenterModule, schedulerModule, roomModule))
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}