package com.saludpublica.evred.Login.Model

class StudentModel(
    override val email: String, override val password: String,
    override val name: String
) : IStudentModel