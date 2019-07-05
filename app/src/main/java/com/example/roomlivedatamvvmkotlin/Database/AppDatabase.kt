package com.example.roomlivedatamvvmkotlin.Database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomlivedatamvvmkotlin.Database.daos.DaosUsers
import com.example.roomlivedatamvvmkotlin.Database.entites.Users


@Database(entities = [(Users::class)],version = 1)
abstract class AppDatabase :RoomDatabase(){

    abstract fun daosUsers() :DaosUsers

    companion object {

        /**
         * The only instance
         */
         var sInstance: AppDatabase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "example")
//                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }


}