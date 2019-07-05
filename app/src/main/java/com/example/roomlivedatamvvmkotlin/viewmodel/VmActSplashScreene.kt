package com.example.roomlivedatamvvmkotlin.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.roomlivedatamvvmkotlin.activites.ActBottomNavDash
import com.example.roomlivedatamvvmkotlin.activites.ActLogin
import com.example.roomlivedatamvvmkotlin.contentprovider.LoginSession

class VmActSplashScreene : AndroidViewModel{

    val loginSession :LoginSession
    lateinit var application_here: Application

    constructor(application: Application):super(application){
        loginSession= LoginSession(application)
        application_here=application
    }

    fun checkIsLogin(){
        if(loginSession.getISLogin()){
            application_here.startActivity(Intent(application_here,ActBottomNavDash::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }else{
            application_here.startActivity(Intent(application_here,ActLogin::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))

        }
    }

}