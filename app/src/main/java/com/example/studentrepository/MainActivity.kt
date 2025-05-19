package com.example.studentrepository

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.main_activity_add_student_button)

        addButton.setOnClickListener {
            val intent = Intent(this, StudentRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}
