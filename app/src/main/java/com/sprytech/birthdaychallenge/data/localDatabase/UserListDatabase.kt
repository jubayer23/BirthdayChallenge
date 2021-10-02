package com.android.chaldhal.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.birthdaychallenge.data.models.Result

@Database(entities = [Result::class], version = 1)
abstract class UserListDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}