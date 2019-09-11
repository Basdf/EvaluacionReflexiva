package com.saludpublica.evred.Login.Model

import android.text.TextUtils
import android.util.Patterns

class UserModel(override val email: String, override val password: String,
                override val name: String) : IUserModel {


    override fun isDataValid(): Int {
        return when {
            TextUtils.isEmpty(email) -> 0 //0 error code is email empty
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1 //1 error code is not a email
            password.length <= 6 -> 2 //2 error code is password length must be greater than 6
            else -> -1 //-1 is success code
        }
    }
}