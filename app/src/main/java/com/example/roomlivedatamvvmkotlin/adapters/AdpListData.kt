package com.example.roomlivedatamvvmkotlin.adapters

import android.content.Context
import android.os.Binder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlivedatamvvmkotlin.R
import com.example.roomlivedatamvvmkotlin.databinding.AdpListBinding
import com.example.roomlivedatamvvmkotlin.model.ModListData
import com.example.roomlivedatamvvmkotlin.viewmodel.VmActDashboard
import kotlinx.android.synthetic.main.adp_list.*

class AdpListData(var context: Context,var arrayList: ArrayList<VmActDashboard>) :RecyclerView.Adapter<AdpListData.ChildHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val binding =DataBindingUtil.inflate<AdpListBinding>(LayoutInflater.from(parent.context),R.layout.adp_list,parent,false)
        return ChildHolder(binding)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        val binding = holder.binder
        var modListData = arrayList.get(position).modListData
        binding.tvName.text=modListData.name
        Log.d("TAG","modListData.name : "+modListData.name)

    }

    class ChildHolder(val binder: AdpListBinding) : RecyclerView.ViewHolder(binder.root)
}