package com.aridwiprayogo.popularmovie.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        PresentationModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent: AndroidInjector<DaggerApplication>{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun builder(context: Context): Builder
        fun build():AppComponent
    }

    override fun inject(app: DaggerApplication?)
}