package com.example.roomlivedatamvvmkotlin.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.roomlivedatamvvmkotlin.R
import com.example.roomlivedatamvvmkotlin.viewmodel.VmActSplashScreene

class ActSplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_splash_screen)

        val viewModel = ViewModelProviders.of(this@ActSplashScreen).get(VmActSplashScreene::class.java)
        viewModel.checkIsLogin()
    }
}
