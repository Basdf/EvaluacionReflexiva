package com.saludpublica.evred.login.Data

import com.saludpublica.evred.login.Model.StudentModel


class StudentData: IStudentData
{
    override fun getStundent(email: String): StudentModel? {
        //if que verifica si el email existe en la base de datos, cambiar luego por la validacion correspondiente
        //con el consumo de apis
        if(email=="eduardo.velasquezv@udea.edu.co"){
            return StudentModel("eduardo.velasquezv@udea.edu.co", "123456789", "eduardo velasquez")
        }
        return null
    }

}