package com.sprytech.birthdaychallenge.data.repository

import androidx.room.withTransaction
import com.android.chaldhal.data.UserListDatabase
import com.android.chaldhal.data.api.ApiService
import com.sprytech.birthdaychallenge.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserBirthdayListReposity @Inject constructor(
    private val api: ApiService,
    private val db: UserListDatabase
) {
    private val restaurantDao = db.userDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllUserList()
        },
        fetch = {
            delay(2000)
            api.getHomeData(100, "chalkboard","name,dob" ).results
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteUserList()
                restaurants?.let { restaurantDao.insertUserList(it) }
            }
        }
    )
}