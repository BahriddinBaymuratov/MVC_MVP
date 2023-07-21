package com.example.mvc_mvp.mvp.presenter

import android.content.Context
import com.example.mvc_mvp.database.AppDatabase
import com.example.mvc_mvp.database.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// PRESENTER
class UserPresenter(
    context: Context,
    private val contractView: ContractView
) {

    private val appDatabase = AppDatabase.getInstance(context)
    private val userDao = appDatabase.dao()

    fun setUsers() {
        contractView.showProgressBar()
        GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            contractView.showUser(userDao.getUser())
            contractView.hideProgressBar()
        }
    }

    fun addUser(name: String, age: Int) {
        val userEntity = UserEntity(name = name, age = age)
        userDao.addUser(userEntity)
        setUsers()
    }
}