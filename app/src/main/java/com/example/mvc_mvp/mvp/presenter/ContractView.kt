package com.example.mvc_mvp.mvp.presenter

import com.example.mvc_mvp.database.UserEntity

interface ContractView {

    fun showUser(userList: List<UserEntity>)

    fun showProgressBar()

    fun hideProgressBar()
}