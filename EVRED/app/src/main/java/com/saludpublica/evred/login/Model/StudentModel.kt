package com.saludpublica.evred.login.Model

class StudentModel(
    override val email: String, override val password: String,
    override val name: String
) : IStudentModel