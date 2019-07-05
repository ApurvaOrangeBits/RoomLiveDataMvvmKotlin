package com.example.roomlivedatamvvmkotlin.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.roomlivedatamvvmkotlin.R
import com.example.roomlivedatamvvmkotlin.databinding.ActSignupBinding
import com.example.roomlivedatamvvmkotlin.databinding.ActivityMainBinding
import com.example.roomlivedatamvvmkotlin.viewmodel.VmActLogin

class ActSignup : AppCompatActivity() {

    lateinit var binding : ActSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActSignupBinding>(this@ActSignup,R.layout.act_signup)

        val viewmodel= ViewModelProviders.of(this@ActSignup).get(VmActLogin(application)::class.java)
        binding.vmactlogin=viewmodel
    }
}
