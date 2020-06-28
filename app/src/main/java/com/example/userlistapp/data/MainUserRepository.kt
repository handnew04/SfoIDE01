package com.example.userlistapp.data

import com.example.userlistapp.data.remote.UserRemoteDataSource

class MainUserRepository(val userRemoteDataSource : UserRemoteDataSource) {
    fun getUsersData(
        success: (UserResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) = userRemoteDataSource.getUsersData(success, fail)

}