package com.example.breukentrainer2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartBasic = findViewById<Button>(R.id.buttonBasic)
        val btnStartAdvanced = findViewById<Button>(R.id.buttonAdvanced)
        val btnTip = findViewById<Button>(R.id.buttonTip)


        btnStartBasic.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            intent.putExtra("Level","Basic")
            // start your next activity
            startActivity(intent)

            finish()
        }

        btnStartAdvanced.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            intent.putExtra("Level","Advanced")
            // start your next activity
            startActivity(intent)

            finish()
        }

        btnTip.setOnClickListener {
            val intent = Intent(this, TipOfTheDayActivity::class.java)
            // start your next activity
            startActivity(intent)

            finish()
        }
    }
}