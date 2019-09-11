package com.saludpublica.evred.Login.View

import com.saludpublica.evred.Login.Model.UserModel


interface ILoginView {
    fun onLoginError(message: String)
    fun onLoginSuccess(message: String, user:UserModel)
}