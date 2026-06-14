package com.example.gizigo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SetupProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_profile)

        val spinnerGender = findViewById<Spinner>(R.id.spinner_gender)
        val genders = arrayOf("Female", "Male")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        spinnerGender.adapter = genderAdapter

        val spinnerActivity = findViewById<Spinner>(R.id.spinner_activity_level)
        val activityLevels = arrayOf("Sedentary (Office job)", "Lightly Active", "Moderately Active", "Very Active")
        val activityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, activityLevels)
        spinnerActivity.adapter = activityAdapter

        findViewById<Button>(R.id.btn_continue).setOnClickListener {
            // Handle continue
        }
    }
}
