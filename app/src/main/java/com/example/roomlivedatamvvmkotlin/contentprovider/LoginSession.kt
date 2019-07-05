package com.example.roomlivedatamvvmkotlin.contentprovider

import android.content.Context
import android.content.SharedPreferences

class LoginSession {

    val ISLOGIN="islogin"

    var sharedPreferences : SharedPreferences
    var editor:SharedPreferences.Editor

    constructor(context: Context){
        sharedPreferences=context.getSharedPreferences("my_prefernce",0)
        editor=sharedPreferences.edit()
    }

    fun setISLogin(value :Boolean){
        editor.putBoolean(ISLOGIN,value)
        editor.commit()
    }

    fun getISLogin() : Boolean{
        return sharedPreferences.getBoolean(ISLOGIN,false)
    }

}