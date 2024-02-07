package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class menu : AppCompatActivity() {
    var btnmovie : ImageButton? = null
    var btnfood : ImageButton? = null
    var btnback : ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        init()
        btnmovie!!.setOnClickListener {
            var intent = Intent(this, ranmovie::class.java)
            startActivity(intent)
        }
        btnfood!!.setOnClickListener {
            var intent = Intent(this, ranfood::class.java)
            startActivity(intent)
        }

        btnback!!.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
        fun init(){

            btnmovie= findViewById(R.id.btnmovie)
            btnfood= findViewById(R.id.btnfood)
            btnback= findViewById(R.id.btnback)
        }
    }
