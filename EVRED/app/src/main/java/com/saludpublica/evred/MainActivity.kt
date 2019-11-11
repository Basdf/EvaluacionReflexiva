package com.saludpublica.evred

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saludpublica.evred.login.Model.StudentModel

import com.saludpublica.evred.login.Presenter.ILoginPresenter
import com.saludpublica.evred.login.Presenter.LoginPresenter
import com.saludpublica.evred.login.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity(), ILoginView {

    override fun onLoginError(message: String) {
        Toasty.error(this,message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccess(message: String,user:StudentModel) {
        Toasty.success(this,message, Toast.LENGTH_LONG).show()
        val intent=Intent(this,NavBarActivity::class.java)
        intent.putExtra("email",user.email)
        intent.putExtra("name",user.name)
        startActivity(intent)
        finish()
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
