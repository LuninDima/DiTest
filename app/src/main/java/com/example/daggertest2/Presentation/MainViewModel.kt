package com.example.daggertest2.Presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.shareprefs.SharedPrefUserStorage
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {
   private val resultLIveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLIveMutable

    init {
        Log.e("AAA", "VM created")
    }

    fun save(text: String){
        val params = SaveUserNameParam(name = text)
        val resultData:Boolean = saveUserNameUseCase.execute(param = params)
        resultLIveMutable.value =   "Save result = $resultData"
    }

    fun load(){
        val userName: UserName = getUserNameUseCase.execute()
        resultLIveMutable.value = "${userName.firstName} ${userName.lastName}"
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }
}