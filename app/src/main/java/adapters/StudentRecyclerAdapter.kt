package adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentrepository.R
import com.example.studentrepository.StudentDetailsActivity
import com.example.studentrepository.model.Student

class StudentRecyclerAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.list_row_username)
        private val idTextView: TextView = itemView.findViewById(R.id.list_row_userid)
        private val checkBox: CheckBox = itemView.findViewById(R.id.list_row_checkbox)

        fun bind(student: Student, position: Int) {
            nameTextView.text = "Name: ${student.name}"
            idTextView.text = "ID: ${student.id}"

            checkBox.isChecked = student.isChecked

            checkBox.setOnClickListener {
                student.isChecked = checkBox.isChecked
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, StudentDetailsActivity::class.java)
                intent.putExtra("position", position)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position], position)
    }

    override fun getItemCount(): Int = students.size
}
