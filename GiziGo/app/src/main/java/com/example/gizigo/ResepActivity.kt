package com.example.gizigo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class ResepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resep)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnTambahHeader = findViewById<Button>(R.id.btn_tambah_resep_header)
        val layoutListResep = findViewById<LinearLayout>(R.id.layout_list_resep)
        val layoutFormResep = findViewById<MaterialCardView>(R.id.layout_form_resep)
        val btnBatal = findViewById<Button>(R.id.btn_batal)
        val btnBagikan = findViewById<Button>(R.id.btn_bagikan)

        // Logic Klik Tambah Resep Baru (Menampilkan Form)
        btnTambahHeader.setOnClickListener {
            layoutListResep.visibility = View.GONE
            layoutFormResep.visibility = View.VISIBLE
            btnTambahHeader.visibility = View.GONE
        }

        // Logic Tombol Batal
        btnBatal.setOnClickListener {
            layoutListResep.visibility = View.VISIBLE
            layoutFormResep.visibility = View.GONE
            btnTambahHeader.visibility = View.VISIBLE
        }

        // Logic Tombol Bagikan (Simulasi)
        btnBagikan.setOnClickListener {
            // Sembunyikan form dan kembali ke list
            layoutListResep.visibility = View.VISIBLE
            layoutFormResep.visibility = View.GONE
            btnTambahHeader.visibility = View.VISIBLE
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
    }
}