package com.example.gizigo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val btnSave = findViewById<android.widget.Button>(R.id.btn_save)
        val etName = findViewById<EditText>(R.id.et_name)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)

        btnBack.setOnClickListener {
            finish()
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                Toast.makeText(this, "Perubahan disimpan!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Mohon lengkapi data", Toast.LENGTH_SHORT).show()
            }
        }

        // Optional: Toggle password visibility
        val icEye = findViewById<ImageView>(R.id.ic_eye)
        var isPasswordVisible = false
        icEye.setOnClickListener {
            if (isPasswordVisible) {
                etPassword.transformationMethod = android.text.method.PasswordTransformationMethod.getInstance()
                icEye.setImageResource(android.R.drawable.ic_menu_view)
            } else {
                etPassword.transformationMethod = android.text.method.HideReturnsTransformationMethod.getInstance()
                // You might want to use a different icon for "hidden"
                icEye.setImageResource(android.R.drawable.ic_menu_view) 
            }
            isPasswordVisible = !isPasswordVisible
            etPassword.setSelection(etPassword.text.length)
        }
    }
}
