package com.example.gizigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val featureCalories = findViewById<CardView>(R.id.feature_calories)
        val featureWorkout = findViewById<CardView>(R.id.feature_workout)

        btnBack.setOnClickListener {
            finish()
        }

        featureCalories.setOnClickListener {
            Toast.makeText(this, "Fitur Hitung Kalori & Gizi", Toast.LENGTH_SHORT).show()
        }

        featureWorkout.setOnClickListener {
            Toast.makeText(this, "Fitur Rekomendasi Olahraga", Toast.LENGTH_SHORT).show()
        }
    }
}
