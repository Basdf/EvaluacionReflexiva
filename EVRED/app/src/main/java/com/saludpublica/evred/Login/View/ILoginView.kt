package com.saludpublica.evred.Login.View

import com.saludpublica.evred.Login.Model.StudentModel


interface ILoginView {
    fun onLoginError(message: String)
    fun onLoginSuccess(message: String, student:StudentModel)
}