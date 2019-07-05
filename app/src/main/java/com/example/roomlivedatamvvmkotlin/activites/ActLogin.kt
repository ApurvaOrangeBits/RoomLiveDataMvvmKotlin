package com.example.roomlivedatamvvmkotlin.activites

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.roomlivedatamvvmkotlin.Database.AppDatabase
import com.example.roomlivedatamvvmkotlin.Database.entites.Users
import com.example.roomlivedatamvvmkotlin.R
import com.example.roomlivedatamvvmkotlin.contentprovider.LoginSession
import com.example.roomlivedatamvvmkotlin.databinding.ActivityMainBinding
import com.example.roomlivedatamvvmkotlin.viewmodel.VmActLogin
import org.jetbrains.anko.doAsync

class ActLogin : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this@ActLogin,R.layout.activity_main)

        val viewmodel= ViewModelProviders.of(this@ActLogin).get(VmActLogin( application)::class.java)
        binding.vmactlogin=viewmodel




    }
}
