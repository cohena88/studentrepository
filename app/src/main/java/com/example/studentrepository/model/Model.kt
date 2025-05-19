package com.example.studentrepository.model

class Model private constructor() {
    val students: MutableList<Student> = mutableListOf()

    companion object {
        val shared: Model = Model()
    }
}
