package com.example.userlistapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userlistapp.data.MainUserRepository
import com.example.userlistapp.data.UserResponse

class MainViewModel(val userRepository: MainUserRepository) : ViewModel() {
    val userInfo = MutableLiveData<UserResponse>()
    val failMessage = MutableLiveData<String>()

    fun getUsersData() {
        userRepository.getUsersData(
            success = {
                userInfo.value = it
            },
            fail = {
                Log.e(
                    "getUserData is Fail",
                    it.message
                )
                failMessage.value = it.message
            }
        )
    }

    fun detailUserButtonClick() {

    }
}