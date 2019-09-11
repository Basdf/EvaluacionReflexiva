package com.saludpublica.evred.Login.Model

interface IUserModel {
    val email:String
    val password:String
    val name:String
    fun isDataValid():Int
}