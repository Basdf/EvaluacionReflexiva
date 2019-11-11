package com.saludpublica.evred.login.Data

import com.saludpublica.evred.login.Model.StudentModel

interface IStudentData {
    fun getStundent(email:String):StudentModel?
}