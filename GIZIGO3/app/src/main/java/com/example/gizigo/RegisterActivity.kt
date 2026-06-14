package com.example.gizigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etFullName = findViewById<EditText>(R.id.et_full_name)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = findViewById<EditText>(R.id.et_confirm_password)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val tvLogin = findViewById<TextView>(R.id.tv_login)

        btnRegister.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan data ke SharedPreferences (seperti yang dilakukan sebelumnya)
            val sharedPref = getSharedPreferences("GIZIGO_PREFS", android.content.Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("USER_NAME", fullName)
                putString("USER_EMAIL", email)
                apply()
            }

            Toast.makeText(this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show()
            
            // Lanjut ke Setup Profile
            val intent = Intent(this, SetupProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvLogin.setOnClickListener {
            finish() // Kembali ke Login
        }
    }
}
