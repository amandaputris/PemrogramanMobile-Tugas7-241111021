package com.example.gizigo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Logic Logout
        findViewById<MaterialButton>(R.id.btn_logout).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
        }

        // Navigasi Bottom Bar
        findViewById<LinearLayout>(R.id.nav_home).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        findViewById<LinearLayout>(R.id.nav_nutrisi).setOnClickListener {
            startActivity(Intent(this, NutrisiActivity::class.java))
            finish()
        }

        findViewById<LinearLayout>(R.id.nav_resep).setOnClickListener {
            startActivity(Intent(this, ResepActivity::class.java))
            finish()
        }

        findViewById<LinearLayout>(R.id.nav_olahraga).setOnClickListener {
            startActivity(Intent(this, OlahragaActivity::class.java))
            finish()
        }
    }
}