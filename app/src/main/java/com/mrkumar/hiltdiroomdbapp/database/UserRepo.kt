package com.mrkumar.hiltdiroomdbapp.database

import javax.inject.Inject

class UserRepo @Inject constructor(private val userDao: UserDao) {

    fun getRecords(): List<UserData> {
        return userDao.getRecords()
    }

    fun insertRecord(userEntity: UserData) {
        userDao.insertRecord(userEntity)
    }
}