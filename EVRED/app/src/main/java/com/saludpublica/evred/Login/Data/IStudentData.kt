package com.saludpublica.evred.Login.Data

import com.saludpublica.evred.Login.Model.StudentModel

interface IStudentData {
    fun getStundent(email:String):StudentModel?
}