package com.example.roomlivedatamvvmkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomlivedatamvvmkotlin.Database.AppDatabase
import com.example.roomlivedatamvvmkotlin.Database.entites.Users

class VmActBottomNavDash :AndroidViewModel{

    var user_name=""
    val application_here:Application
    var registered_user_list:MutableLiveData<ArrayList<Users>>  ?=null
    var database : AppDatabase

    constructor(application: Application):super(application){
        application_here=application
        database = AppDatabase.getInstance(application)
    }

    constructor(application: Application,users: Users):super(application){
        application_here=application
        user_name=users.name
        database = AppDatabase.getInstance(application)
    }


    fun getRegistereUserList():MutableLiveData<ArrayList<Users>>?{

        if(registered_user_list==null){
            var userList = ArrayList<Users>()
            registered_user_list=MutableLiveData()
            userList= database.daosUsers().selectAllUsers()

            for (i in userList){
                Log.d("TAG","users name : "+i.name)
            }


        }

        return registered_user_list
    }








}
