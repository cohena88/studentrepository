package com.example.studentrepository

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.studentrepository.model.Model
import com.example.studentrepository.model.Student

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val nameEditText: EditText = findViewById(R.id.edit_name)
        val idEditText: EditText = findViewById(R.id.edit_id)
        val phoneEditText: EditText = findViewById(R.id.edit_phone)
        val addressEditText: EditText = findViewById(R.id.edit_address)
        val checkBox: CheckBox = findViewById(R.id.edit_checkbox)

        val cancelButton: Button = findViewById(R.id.edit_cancel_button)
        val saveButton: Button = findViewById(R.id.edit_save_button)

        cancelButton.setOnClickListener { finish() }

        saveButton.setOnClickListener {
            val student = Student(
                name = nameEditText.text.toString(),
                id = idEditText.text.toString(),
                phone = phoneEditText.text.toString(),
                address = addressEditText.text.toString(),
                image = "student", // 🖼️ ערך ברירת מחדל לתמונה
                isChecked = checkBox.isChecked
            )
            Model.shared.students.add(student)
            finish()
        }
    }
}
