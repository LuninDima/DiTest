package com.example.daggertest2.di

import android.content.Context
import com.example.daggertest2.Presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {



    fun inject(mainActivity: MainActivity)
}