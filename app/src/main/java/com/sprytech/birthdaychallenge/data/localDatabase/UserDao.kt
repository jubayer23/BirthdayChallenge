package com.android.chaldhal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.android.birthdaychallenge.data.models.Result

@Dao
interface UserDao {

    @Query("SELECT * FROM userlist")
    fun getAllUserList(): Flow<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserList(userlist: List<Result>)

    @Query("DELETE FROM userlist")
    suspend fun deleteUserList()
}