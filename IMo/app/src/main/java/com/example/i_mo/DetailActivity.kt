package com.example.i_mo

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_PRODUCT", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_PRODUCT")
        }

        product?.let {
            val ivDetailImage: ImageView = findViewById(R.id.ivDetailImage)
            val tvDetailTitle: TextView = findViewById(R.id.tvDetailTitle)
            val tvDetailPrice: TextView = findViewById(R.id.tvDetailPrice)
            val tvDetailCategory: TextView = findViewById(R.id.tvDetailCategory)
            val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)

            tvDetailTitle.text = it.title
            tvDetailPrice.text = "$${it.price}"
            tvDetailCategory.text = it.category
            tvDetailDescription.text = it.description

            Glide.with(this)
                .load(it.image)
                .into(ivDetailImage)
            
            supportActionBar?.title = it.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
