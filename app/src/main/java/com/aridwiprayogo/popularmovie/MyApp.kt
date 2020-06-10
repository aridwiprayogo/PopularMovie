package com.aridwiprayogo.popularmovie

import com.aridwiprayogo.popularmovie.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().builder(this).build().apply {
            inject(this@MyApp)
        }
}