package com.example.daggertest2.di

import android.content.Context
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.UserStorage
import com.example.data.data.storage.shareprefs.SharedPrefUserStorage
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import org.koin.dsl.module
import kotlin.contracts.contract


@Module
class DataModule(){
    @Provides
    fun provideSharedPrefUserStorage(context:Context):UserStorage{
         val userStorage = SharedPrefUserStorage(context = context)
        return userStorage
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        val userRepository = UserRepositoryImpl(userStorage = userStorage)
        return userRepository
    }
}

//koin
   /* val dataModule = module {
        single<UserStorage> {
            SharedPrefUserStorage(context = get())
        }

        single<UserRepository> {
            UserRepositoryImpl(userStorage = get())
        }
    }*/
