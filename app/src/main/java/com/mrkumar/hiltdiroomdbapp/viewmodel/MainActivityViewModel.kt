package com.mrkumar.hiltdiroomdbapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrkumar.hiltdiroomdbapp.database.UserData
import com.mrkumar.hiltdiroomdbapp.database.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repo: UserRepo):ViewModel() {

     var userData:MutableLiveData<List<UserData>> = MutableLiveData()

    fun getRecordsObserver(): MutableLiveData<List<UserData>> {
        return userData
    }

     fun loadRecords(){
        val list = repo.getRecords()
        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserData) {
        if (userEntity.name.isNotBlank()) {
            repo.insertRecord(userEntity)
            loadRecords()
        }
    }

}