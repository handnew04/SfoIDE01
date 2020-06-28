package com.example.userlistapp.data.remote

import com.example.userlistapp.data.UserResponse

interface UserRemoteDataSource {
    fun getUsersData(
        success: (UserResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}