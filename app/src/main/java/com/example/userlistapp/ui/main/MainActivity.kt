package com.example.userlistapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.userlistapp.R
import com.example.userlistapp.adapter.MainRecyclerAdapter
import com.example.userlistapp.data.MainUserRepository
import com.example.userlistapp.data.remote.UserRemoteDataSourceImpl
import com.example.userlistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: MainRecyclerAdapter
    lateinit var binding: ActivityMainBinding

    val mainViewModel: MainViewModel by lazy {
        MainViewModel(
            MainUserRepository(
                UserRemoteDataSourceImpl()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        initailize()
        initBinding()
        initObserveCallback()
    }

    private fun initailize() {
        recyclerAdapter = MainRecyclerAdapter()
        mainViewModel.getUsersData()
    }


    private fun initBinding() {
        binding.rcvMain.adapter = recyclerAdapter
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this@MainActivity
    }

    private fun initObserveCallback() {
        with(mainViewModel) {
            failMessage.observe(this@MainActivity, Observer {
                showFailMessage(failMessage.toString())
            })
        }
    }

    private fun showFailMessage(failMessage: String) {
        Toast.makeText(this@MainActivity, "유저 데이터 가져오기 실패 $failMessage", Toast.LENGTH_SHORT).show()
    }

}
