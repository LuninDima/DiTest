package com.example.daggertest2.Presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.shareprefs.SharedPrefUserStorage
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userStorage by lazy { SharedPrefUserStorage(context = context) }
    private val userRepository by lazy { UserRepositoryImpl(userStorage) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}