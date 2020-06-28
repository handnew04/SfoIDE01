package com.example.userlistapp.data.remote

import com.example.userlistapp.data.UserResponse
import com.example.userlistapp.network.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRemoteDataSourceImpl : UserRemoteDataSource {
    override fun getUsersData(success: (UserResponse) -> Unit, fail: (Throwable) -> Unit) {
        retrofitService()
            .requestUsersData()
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    if (response.isSuccessful) {
                        success(response.body() as UserResponse)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    fail(t)
                }
            })
    }

}