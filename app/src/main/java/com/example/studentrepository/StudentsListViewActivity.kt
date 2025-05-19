import com.example.studentrepository.R
import android.content.Intent
import com.example.studentrepository.StudentDetailsActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.TextView
import com.example.studentrepository.model.Model
import com.example.studentrepository.model.Student

class StudentsListViewActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
        val listView: ListView = findViewById(R.id.students_list_view)
        listView.adapter = StudentAdapter()

        // ✅ טיפול בלחיצה על פריט ברשימה
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    inner class StudentAdapter : BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(position: Int): Any = students?.get(position) ?: ""

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(parent?.context)
            val view = convertView ?: inflater.inflate(R.layout.list_row, parent, false)

            val student = students?.get(position)
            val nameTextView: TextView = view.findViewById(R.id.list_row_username)
            val idTextView: TextView = view.findViewById(R.id.list_row_userid)
            val checkbox: CheckBox = view.findViewById(R.id.list_row_checkbox)

            nameTextView.text = student?.name
            idTextView.text = "Student ID: ${student?.id}"
            checkbox.isChecked = student?.isChecked ?: false
            checkbox.tag = position

            checkbox.setOnClickListener {
                val student = students?.get(checkbox.tag as Int)
                student?.isChecked = checkbox.isChecked
            }

            return view
        }
    }
}
