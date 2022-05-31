package com.mrkumar.hiltdiroomdbapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserData(

    @PrimaryKey(true)
    @ColumnInfo("id")
    val id:Int=0,

    @ColumnInfo("name")
    val name:String

)
