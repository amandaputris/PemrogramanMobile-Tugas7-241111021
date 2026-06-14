package com.example.gizigo

import android.os.Bundle
import android.util.Patterns
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EditProfilActivity : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupListeners()
    }

    private fun initViews() {
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        tilName = findViewById(R.id.til_name)
        tilEmail = findViewById(R.id.til_email)
    }

    private fun setupListeners() {
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<MaterialButton>(R.id.btn_save).setOnClickListener {
            if (validateForm()) {
                // Here we would normally save the data
                Toast.makeText(this, getString(R.string.msg_edit_success), Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()

        if (name.isEmpty()) {
            tilName.error = getString(R.string.error_name_empty)
            isValid = false
        } else {
            tilName.error = null
        }

        if (email.isEmpty()) {
            tilEmail.error = getString(R.string.error_email_invalid)
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.error = getString(R.string.error_email_invalid)
            isValid = false
        } else {
            tilEmail.error = null
        }

        return isValid
    }
}