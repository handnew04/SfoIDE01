package com.example.userlistapp.network

import com.example.userlistapp.data.UserResponse
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/?results=50")
    fun requestUsersData(): retrofit2.Call<UserResponse>
}