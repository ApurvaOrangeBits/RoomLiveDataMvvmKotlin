package com.example.roomlivedatamvvmkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomlivedatamvvmkotlin.model.ModListData

class VmActDashboard :AndroidViewModel{
     var application_here:Application
    lateinit var modListData : ModListData

    constructor(application: Application):super(application){
        this.application_here =application
        Log.d("TAG","application constructor")
    }
    constructor(application: Application,modListData: ModListData):super(application){
        this.application_here =application
        this.modListData=modListData
        Log.d("TAG","modListData constructor")
    }


    var listDataNew : MutableLiveData<ArrayList<VmActDashboard>> ?=null
    lateinit var arrayList :ArrayList<VmActDashboard>

     fun setList() : MutableLiveData<ArrayList<VmActDashboard>>{
        if(listDataNew==null){
            arrayList= ArrayList()
            listDataNew= MutableLiveData()
            Log.d("TAG","listdata is null")
            var modListData1 = ModListData("Neha")
            var modListData2 = ModListData("Sneha")
            var modListData3 = ModListData("Jaya")
            var modListData4 = ModListData("Radha")

            var vmActDashboard1 = VmActDashboard(application_here,modListData1)
            var vmActDashboard2 = VmActDashboard(application_here,modListData2)
            var vmActDashboard3 = VmActDashboard(application_here,modListData3)
            var vmActDashboard4 = VmActDashboard(application_here,modListData4)
            arrayList.add(vmActDashboard1)
            arrayList.add(vmActDashboard2)
            arrayList.add(vmActDashboard3)
            arrayList.add(vmActDashboard4)

            listDataNew!!.value=arrayList

        }
         return listDataNew!!
    }
}