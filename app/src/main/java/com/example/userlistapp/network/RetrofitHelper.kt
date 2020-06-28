package com.example.userlistapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BuildRetrofit {
    val baseUrl = "https://randomuser.me/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(NetworkHttpClient.okHttpClient)
        .build()
}

object NetworkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(initLogInterceptor())
        .build()
}

fun initLogInterceptor() :HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun retrofitService() = BuildRetrofit.retrofit.create(RetrofitService::class.java)