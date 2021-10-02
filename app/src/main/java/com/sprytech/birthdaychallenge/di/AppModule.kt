package com.sprytech.birthdaychallenge.di


import android.app.Application
import androidx.room.Room
import com.android.chaldhal.data.UserListDatabase
import com.android.chaldhal.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val URL = "https://randomuser.me/"


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideDatabase(app: Application) : UserListDatabase =
        Room.databaseBuilder(app, UserListDatabase::class.java, "userlist_database")
            .build()

}