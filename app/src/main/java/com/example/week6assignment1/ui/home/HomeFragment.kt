package com.example.week6assignment1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment1.R
import com.example.week6assignment1.ui.adapter.StudentAdapter
import com.example.week6assignment1.ui.model.Student
import com.example.week6assignment1.parcel.StudentData

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private  var  lstStudent = ArrayList<Student>()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        recyclerView = root.findViewById(R.id.recyclerView)
if(StudentData.studentList.size == 0)
{
    StudentData.studentData()
}

        lstStudent = StudentData.studentList
        val adapter = StudentAdapter(lstStudent,container!!.context)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return root
    }

}