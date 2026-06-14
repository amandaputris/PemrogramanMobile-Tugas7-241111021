package com.example.gizigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NutritionCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_check)

        val btnBack = findViewById<ImageView>(R.id.btn_back) // I should add this to layout
        // For now, let's just implement the basic logic if needed, but the UI is the focus.
    }
}
