package com.example.mvc_mvp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("select * from userentity")
    fun getUser(): List<UserEntity>
}