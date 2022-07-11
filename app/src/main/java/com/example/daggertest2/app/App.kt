package com.example.daggertest2.app

import android.app.Application
import android.content.Context
import com.example.daggertest2.di.AppComponent
import com.example.daggertest2.di.DaggerAppComponent


class App : Application() {
     lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is  App -> appComponent
        else -> applicationContext.appComponent
    }

/*        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule, dataModule, domainModule)
        }
    }*/