package com.saludpublica.evred

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saludpublica.evred.Login.Model.UserModel

import com.saludpublica.evred.Login.Presenter.ILoginPresenter
import com.saludpublica.evred.Login.Presenter.LoginPresenter
import com.saludpublica.evred.Login.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity(), ILoginView {

    override fun onLoginError(message: String) {
        Toasty.error(this,message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccess(message: String,user:UserModel) {
        Toasty.success(this,message, Toast.LENGTH_LONG).show()
        //val intent=Intent(this,HomeActivity::class.java)
//        intent.putExtra("email",user.email)
//        intent.putExtra("name",user.name)
        startActivity(intent)
    }

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //init
        loginPresenter = LoginPresenter(this)

        //event
        loginButton.setOnClickListener {
            loginPresenter.onLogin(emailEditText.text.toString(), passwordEditText.text.toString())
        }
    }
}
