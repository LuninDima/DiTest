package com.example.data.data.storage

import com.example.data.data.storage.models.User

interface UserStorage {
    fun save(user: User):Boolean
    fun  get(): User
}