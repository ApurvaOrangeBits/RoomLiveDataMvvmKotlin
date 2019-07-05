package com.example.roomlivedatamvvmkotlin.Database.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class Users constructor (mobile:String ,name:String, password :String){

    @PrimaryKey(autoGenerate = true)
    var uid :Int = 0 // or foodId: Int? = null

    @ColumnInfo(name = "name")
    var name:String =name

    var password :String = password
    var mobile :String = mobile
}