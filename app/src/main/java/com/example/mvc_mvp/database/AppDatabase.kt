package com.example.mvc_mvp.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // MVP DAGI MODEL
    abstract fun dao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "my_db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}