package com.example.daggertest2.di

import android.content.Context
import com.example.daggertest2.Presentation.MainViewModelFactory
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule() {

   @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}

/*
Koin
val appModule = module {
    viewModel<MainViewModel>(){
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
                )
    }
}*/
