package com.mrkumar.hiltdiroomdbapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDatabase(): RoomDatabase() {

    abstract fun getDAO(): UserDao

    companion object {
        private var dbINSTANCE: UserDatabase? = null

        fun getAppDB(context: Context): UserDatabase{
            if(dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder<UserDatabase>(
                    context.applicationContext, UserDatabase::class.java, "USERDATA"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }
    }
}

