package com.example.mvc_mvp.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.mvc_mvp.R
import com.example.mvc_mvp.adapter.UserAdapter
import com.example.mvc_mvp.database.UserEntity
import com.example.mvc_mvp.databinding.ActivitySecondBinding
import com.example.mvc_mvp.mvp.presenter.ContractView
import com.example.mvc_mvp.mvp.presenter.UserPresenter

class SecondActivity : AppCompatActivity(), ContractView {
    lateinit var binding: ActivitySecondBinding
    lateinit var userPresenter: UserPresenter
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // MVP -> Model View Presenter

        userAdapter = UserAdapter()
        binding.rv.adapter = userAdapter

        userPresenter = UserPresenter(this,this)
        userPresenter.setUsers()

        binding.save.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val age = binding.editAge.text.toString().toInt()
            userPresenter.addUser(name, age)
        }
    }

    override fun showProgressBar() {
        binding.progressBar.isVisible = true
        binding.rv.isVisible = false
    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
        binding.rv.isVisible = true
    }

    override fun showUser(userList: List<UserEntity>) {
        userAdapter.submitList(userList)
    }
}