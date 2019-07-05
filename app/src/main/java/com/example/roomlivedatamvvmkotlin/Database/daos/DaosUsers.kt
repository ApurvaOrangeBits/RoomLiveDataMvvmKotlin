package com.example.roomlivedatamvvmkotlin.Database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomlivedatamvvmkotlin.Database.entites.Users

@Dao
interface DaosUsers{

    @Query("SELECT * FROM users WHERE name LIKE :hname AND password LIKE :hpassword")
    fun checkCustomer(hname :String,hpassword:String) :Users

    @Insert
    fun insertUser(users: Users)

    @Query("SELECt * FROM users")
    fun selectAllUsers() : ArrayList<Users>
}