package com.example.week6assignment1.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment1.MainActivity
import com.example.week6assignment1.R
import com.example.week6assignment1.parcel.StudentData
//import com.example.week6assignment1.parcel.StudentData
import com.example.week6assignment1.ui.adapter.StudentAdapter
import com.example.week6assignment1.ui.home.HomeFragment
import com.example.week6assignment1.ui.model.Student

class DashboardFragment : Fragment(), View.OnClickListener  {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var inputUsername: EditText
    private lateinit var inputAddress: EditText
    private lateinit var inputAge: EditText
    private lateinit var groupradio: RadioGroup
    private lateinit var btnSubmit: Button
    private var gender = ""
    private var image = ""
    private lateinit var recyclerView: RecyclerView
    private  var  lstStudent = ArrayList<Student>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        inputUsername = root.findViewById(R.id.inputUsername)
        inputAddress = root.findViewById(R.id.inputAddress)
        inputAge = root.findViewById(R.id.inputAge)
        groupradio = root.findViewById(R.id.groupradio)
        btnSubmit = root.findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener(this)





        return root
    }

    private fun rbg() {
        when (groupradio.checkedRadioButtonId) {
            R.id.rbMale -> gender = "Male"
            R.id.rbFemale -> gender = "Female"
            R.id.rbOther -> gender = "Other"
        }
        if (gender == "Male") {
            image = "https://digiimento.com/wp-content/uploads/2015/11/avatar-male-200x200.png"
        }
        if (gender == "Female") {
            image =
                "https://avatarmaker.net/images/8.png"
        }
        if (gender == "Other") {
            image = "https://img.icons8.com/cotton/2x/gender.png"
        }



    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSubmit -> {
                rbg()
               val id = StudentData.studentList.size+1
           StudentData.studentList.add(Student(id,inputUsername.text.toString(),
           image, inputAge.text.toString(),inputAddress.text.toString(),gender))



                val intent = Intent(context, MainActivity::class.java)

                startActivity(intent)
//
//                Toast.makeText(context, "$id", Toast.LENGTH_SHORT).show()

            }
        }
    }
}