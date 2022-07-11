package com.example.daggertest2.di

import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import org.koin.dsl.module


@Module
class DomainModule() {
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        val getUserNameUseCase = GetUserNameUseCase(userRepository = userRepository)
        return getUserNameUseCase
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        val saveUserNameUseCase = SaveUserNameUseCase(userRepository = userRepository)
        return saveUserNameUseCase
    }
}

/*
Koin
val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}
*/

