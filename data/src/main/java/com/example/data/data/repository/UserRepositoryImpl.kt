package com.example.data.data.repository

import com.example.data.data.storage.models.User
import com.example.data.data.storage.UserStorage
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveName(saveParam: SaveUserNameParam):Boolean{
        val user = mapToStorage(saveParam)
   val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
         val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam):User{
        return User(firstName = saveParam.name, lastName = "last name")
    }
}