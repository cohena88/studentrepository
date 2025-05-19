package com.example.studentrepository

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentrepository.model.Model
import adapters.StudentRecyclerAdapter

class StudentRecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_recycler_view)

        recyclerView = findViewById(R.id.student_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentRecyclerAdapter(Model.shared.students)
        recyclerView.adapter = adapter

        // עדכון מ־Button ל־ImageButton 👇
        val addButton: ImageButton = findViewById(R.id.add_button)
        addButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
