package com.example.week6assignment1.parcel

import android.os.Parcel
import android.os.Parcelable
import com.example.week6assignment1.ui.model.Student
class StudentData(){
    companion object{
        var studentList = arrayListOf<Student>()
        fun studentData(){

            studentList.add(Student(1,"Shiva Basnet",
                "https://digiimento.com/wp-content/uploads/2015/11/avatar-male-200x200.png",
                "21","Manohara","Male"))
//            studentList.add(Student(2,"cristiano",
//                "https://i.pinimg.com/originals/a0/d0/5d/a0d05d7f7ff205d029bd7e4ec2a59b41.jpg",
//                "21","Manohara","Male"))

        }
    }


}
