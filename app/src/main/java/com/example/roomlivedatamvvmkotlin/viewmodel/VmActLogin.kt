package com.example.roomlivedatamvvmkotlin.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomlivedatamvvmkotlin.Database.AppDatabase
import com.example.roomlivedatamvvmkotlin.Database.entites.Users
import com.example.roomlivedatamvvmkotlin.activites.ActBottomNavDash
import com.example.roomlivedatamvvmkotlin.activites.ActDashboard
import com.example.roomlivedatamvvmkotlin.activites.ActLogin
import com.example.roomlivedatamvvmkotlin.activites.ActSignup
import com.example.roomlivedatamvvmkotlin.contentprovider.LoginSession
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class VmActLogin : AndroidViewModel{

    var database:AppDatabase
     var application_reference:Application
    lateinit var loginSession: LoginSession

    constructor(application: Application):super(application){
        Toast.makeText(application,"application",Toast.LENGTH_SHORT).show()
        this.database=AppDatabase.getInstance(application)
        application_reference = application
        Log.d("TAG","database : "+database)

        loginSession= LoginSession(application)
    }


    var name : MutableLiveData<String>
    var password : MutableLiveData<String>
    var confirm_password : MutableLiveData<String>
    var mobile : MutableLiveData<String>

    init {
        this.name = MutableLiveData()
        this.password = MutableLiveData()
        this.confirm_password = MutableLiveData()
        this.mobile = MutableLiveData()
    }

     fun btnLoginClick(){

         if(name.value.equals("")){
             Log.d("TAG","Please enter name")
             Toast.makeText(getApplication(),"Please enter name",Toast.LENGTH_SHORT).show()
         }else if(password.value.equals("")){
             Log.d("TAG","please enter password")
             Toast.makeText(getApplication(),"please enter password",Toast.LENGTH_SHORT).show()
         }else{
             doAsync {

                 val user =database.daosUsers().checkCustomer(name.value.toString(), password.value.toString())
                 if(user == null){

                     uiThread {

                         Toast.makeText(getApplication(),"Invalid credentials",Toast.LENGTH_SHORT).show()
                     }
                 }else{
                    val intent = Intent(getApplication(),ActBottomNavDash::class.java)
                     intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                     application_reference.startActivity(intent)
                     loginSession.setISLogin(true)
                     Log.d("TAG","database data name : "+user.name + " password : "+user.password+
                     "uid : "+user.uid)
                 }
             }
         }
         Log.d("TAG","login name : "+name.value)
         Log.d("TAG","login password : "+password.value)
    }

    fun btnSignupClick(){
        application_reference.startActivity(Intent(application_reference,ActSignup::class.java))
    }


    //--------------sign up page-------------

    fun saveUser(){

        if(name.value.equals("")){
            Log.d("TAG","Please enter name")
            Toast.makeText(getApplication(),"Please enter name",Toast.LENGTH_SHORT).show()
        }else if(mobile.value.equals("")){
            Log.d("TAG","please enter password")
            Toast.makeText(getApplication(),"please enter mobile",Toast.LENGTH_SHORT).show()
        }else if(password.value.equals("")){
            Log.d("TAG","please enter password")
            Toast.makeText(getApplication(),"please enter password",Toast.LENGTH_SHORT).show()
        }else if(confirm_password.value.equals("")){
            Log.d("TAG","please enter password")
            Toast.makeText(getApplication(),"please enter confirm password",Toast.LENGTH_SHORT).show()
        }else if(!password.value.equals(confirm_password.value.toString())){
            Toast.makeText(getApplication(),"Confirm password does not match",Toast.LENGTH_SHORT).show()
        }else{
            doAsync {


              database.daosUsers().insertUser(Users(mobile = mobile.value.toString(),name = name.value.toString(),password = password.value.toString()))
                val intent = Intent(getApplication(),ActBottomNavDash::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                application_reference.startActivity(intent)
                loginSession.setISLogin(true)
            }
        }
        Log.d("TAG","login name : "+name.value)
        Log.d("TAG","login password : "+password.value)
    }



}