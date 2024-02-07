package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    var btnmenu : ImageButton? = null
    var btnlist : ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()
        btnmenu!!.setOnClickListener{
            var intent = Intent(this,menu ::class.java)
            startActivity(intent)
        }
//        btnlist!!.setOnClickListener{
//            var intent = Intent(this,list ::class.java)
//            startActivity(intent)
//        }


    }

    fun init(){

        btnmenu= findViewById(R.id.btnmenu)
//        btnlist= findViewById(R.id.btnlist)
    }


}
