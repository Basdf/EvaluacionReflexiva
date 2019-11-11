package com.saludpublica.evred.login.View

import com.saludpublica.evred.login.Model.StudentModel


interface ILoginView {
    fun onLoginError(message: String)
    fun onLoginSuccess(message: String, student:StudentModel)
}