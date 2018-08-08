package com.example.vikaslandge.sensortest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var sensor = sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        //var sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        //var sensor = sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
       // var sensor = sManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        sManager.registerListener(object : SensorEventListener{
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }

            override fun onSensorChanged(p0: SensorEvent?) {
                var values = p0!!.values
                 Toast.makeText(this@MainActivity,values.size.toString(),Toast.LENGTH_LONG).show()
                textView2.text = values.size.toString()
                textView.text = values[0].toString()
             }

        },sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
}
