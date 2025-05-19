package com.example.studentrepository.model

data class Student(
    var name: String,
    var id: String,
    var phone: String = "",
    var address: String = "",
    val image: String = "test",
    var isChecked: Boolean = false
)
