package com.example.gizigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val switchPush = findViewById<SwitchCompat>(R.id.switch_push)
        val switchEmail = findViewById<SwitchCompat>(R.id.switch_email)

        btnBack.setOnClickListener {
            finish()
        }

        switchPush.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "diaktifkan" else "dimatikan"
            Toast.makeText(this, "Notifikasi Push $status", Toast.LENGTH_SHORT).show()
        }

        switchEmail.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "diaktifkan" else "dimatikan"
            Toast.makeText(this, "Email Notifikasi $status", Toast.LENGTH_SHORT).show()
        }
    }
}
