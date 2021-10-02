package com.sprytech.birthdaychallenge.ui.userBirthdayList


import android.os.Bundle
import androidx.lifecycle.*

import com.sprytech.birthdaychallenge.data.repository.UserBirthdayListReposity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BirthdayListViewModel @Inject constructor(
    private val repositoryImpl: UserBirthdayListReposity
) : ViewModel() {


    val restaurants = repositoryImpl.getRestaurants().asLiveData()

    /*private val _homeList: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    val homeResponse: LiveData<Resource<ApiResponse>>
        get() = _homeList


    init{
        fetchUserList()

    }

    private fun fetchUserList() {

        viewModelScope.launch {
            _homeList.value = Resource.Loading
            _homeList.value = repositoryImpl.getHomeResponse(PAGE_SIZE_LIMIT, "chalkboard", "name,dob")
        }
    }*/




}