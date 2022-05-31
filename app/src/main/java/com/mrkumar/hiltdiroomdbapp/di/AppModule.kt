package com.mrkumar.hiltdiroomdbapp.di

import android.app.Application
import com.mrkumar.hiltdiroomdbapp.database.UserDao
import com.mrkumar.hiltdiroomdbapp.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context:Application):UserDatabase{
        return UserDatabase.getAppDB(context)
    }


    @Singleton
    @Provides
    fun getDao(appDB:UserDatabase):UserDao{
        return appDB.getDAO()
    }
}