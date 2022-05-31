package com.mrkumar.hiltdiroomdbapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM UserData ORDER BY id DESC")
    fun getRecords(): List<UserData>


    @Insert
    fun insertRecord(userEntity: UserData)
}