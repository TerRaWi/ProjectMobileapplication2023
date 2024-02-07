package com.example.project

import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import kotlin.random.Random
import android.graphics.Color.GREEN
import android.widget.TextView


class ranfood : AppCompatActivity(), SensorEventListener {

    var imageButton : ImageView? = null

    private lateinit var sensorManager: SensorManager
    private  lateinit var square: TextView

    lateinit var imageview: ImageView
    lateinit var button: Button

    var foods = arrayOf(
        "Minced pork omelette",
        "Stir fried pork with basil",
        "Papaya salad",
        "Boiled egg, Bael leaves",
        "Pad Thai",
        "Korat Noodle",
        "Shrimp Salad",
        "Boiled pork noodles",
        "Steamed sea",
        "Steamed rices",
        "Pork Belly",
        "Liang Vegetable Fried Eggs"
    )
    var food = arrayOf<Int>(
        R.drawable.image01,
        R.drawable.image02,
        R.drawable.image03,
        R.drawable.image04,
        R.drawable.image05,
        R.drawable.image06,
        R.drawable.image07,
        R.drawable.image08

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranfood)

        init()
        imageButton!!.setOnClickListener{
            var intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        imageview = findViewById(R.id.thumbnaill);
        button = findViewById(R.id.buttonn);

        button.setOnClickListener{
            val random = Random
            imageview.setImageResource(food[random.nextInt(food.size)])
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        square = findViewById(R.id.tv_squaree)

        setUpSensorStuff()
    }
    private fun setUpSensorStuff(){
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            var sides = event.values[0]
            var upDown = event.values[1]

            square.apply{
                rotationX = upDown * 3f
                rotationY = sides * 3f
                rotation = -sides
                translationX = sides * -10
                translationY = upDown *10
            }

            val color = if(upDown.toInt() ==0 && sides.toInt() == 0) Color.GREEN else Color.RED
//            square.setBackgroundColor(color)
//            square.text = "up/down ${upDown.toInt()}\nleft/right ${sides.toInt()}"

            if(color == GREEN) {
                val random = Random
                imageview.setImageResource(food[random.nextInt(food.size)])
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }


    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }

    fun init(){
        imageButton= findViewById(R.id.imageButton)
    }
}