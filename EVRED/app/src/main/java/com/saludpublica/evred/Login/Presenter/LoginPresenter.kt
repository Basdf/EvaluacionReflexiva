package com.saludpublica.evred.Login.Presenter

import com.saludpublica.evred.Login.Model.UserModel
import com.saludpublica.evred.Login.View.ILoginView

class LoginPresenter(internal var iLoginView: ILoginView) : ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        var name="eduardo "//buscar el nombre en base de datos
        val user = UserModel(email, password,name)
        val isLoginCode = user.isDataValid()
        when (isLoginCode) {
            0 -> iLoginView.onLoginError("login error 0")
            1 -> iLoginView.onLoginError("login error 1")
            2 -> iLoginView.onLoginError("login error 2")
            -1 -> iLoginView.onLoginSuccess("login success",user)
        }
    }
}