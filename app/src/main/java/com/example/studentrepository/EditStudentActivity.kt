package com.example.studentrepository

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.studentrepository.model.Model
import com.example.studentrepository.model.Student

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val position = intent.getIntExtra("position", -1)
        if (position == -1) {
            finish()
            return
        }

        val student = Model.shared.students[position]

        val nameEditText: EditText = findViewById(R.id.edit_name)
        val idEditText: EditText = findViewById(R.id.edit_id)
        val phoneEditText: EditText = findViewById(R.id.edit_phone)
        val addressEditText: EditText = findViewById(R.id.edit_address)
        val checkBox: CheckBox = findViewById(R.id.edit_checkbox)

        val cancelButton: Button = findViewById(R.id.edit_cancel_button)
        val deleteButton: Button = findViewById(R.id.edit_delete_button)
        val saveButton: Button = findViewById(R.id.edit_save_button)

        // הצגת ערכים קיימים במסך העריכה
        nameEditText.setText(student.name)
        idEditText.setText(student.id)
        phoneEditText.setText(student.phone)
        addressEditText.setText(student.address)
        checkBox.isChecked = student.isChecked

        cancelButton.setOnClickListener {
            finish()
        }

        deleteButton.setOnClickListener {
            Model.shared.students.removeAt(position)
            finish()
        }

        saveButton.setOnClickListener {
            student.name = nameEditText.text.toString()
            student.id = idEditText.text.toString()
            student.phone = phoneEditText.text.toString()
            student.address = addressEditText.text.toString()
            student.isChecked = checkBox.isChecked
            finish()
        }
    }
}
