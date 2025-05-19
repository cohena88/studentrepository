package com.example.studentrepository

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.studentrepository.model.Model
import com.example.studentrepository.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        // הגדרת הטולבר העליון
        val toolbar: Toolbar = findViewById(R.id.toolbar_details)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Student Details"

        val position = intent.getIntExtra("position", -1)
        if (position == -1) {
            finish()
            return
        }

        val student: Student = Model.shared.students[position]

        val nameTextView: TextView = findViewById(R.id.detail_name)
        val idTextView: TextView = findViewById(R.id.detail_id)
        val phoneTextView: TextView = findViewById(R.id.detail_phone)
        val addressTextView: TextView = findViewById(R.id.detail_address)
        val checkBox: CheckBox = findViewById(R.id.detail_checkbox)
        val editButton: Button = findViewById(R.id.detail_edit_button)
        val imageView: ImageView = findViewById(R.id.detail_image)

        // הצגת פרטי הסטודנט
        nameTextView.text = "Name: ${student.name}"
        idTextView.text = "ID: ${student.id}"
        phoneTextView.text = "Phone: ${student.phone ?: "N/A"}"
        addressTextView.text = "Address: ${student.address ?: "N/A"}"
        checkBox.isChecked = student.isChecked
        imageView.setImageResource(R.drawable.student)

        // מעבר לעמוד העריכה
        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}
