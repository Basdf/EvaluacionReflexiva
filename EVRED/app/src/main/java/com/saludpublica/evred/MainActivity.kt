package com.saludpublica.evred

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saludpublica.evred.login.Model.UserModel
import com.saludpublica.evred.login.Presenter.ILoginPresenter
import com.saludpublica.evred.login.Presenter.LoginPresenter
import com.saludpublica.evred.login.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity(), ILoginView {

    override fun onLoginError(message: String) {
        Toasty.error(this,message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccess(message: String, user:UserModel) {
        Toasty.success(this,message, Toast.LENGTH_LONG).show()
        val intent=Intent(this,NavBarActivity::class.java)
        val pref = applicationContext.getSharedPreferences(
            "UserData",
            Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putString("email",user.email)
        editor.putString("name",user.name)
        editor.putString("cargo",user.cargo)
        editor.commit()
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
