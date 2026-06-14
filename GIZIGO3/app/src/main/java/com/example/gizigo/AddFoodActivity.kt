package com.example.gizigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        setupNutrientInputs()
        setupBottomNav()
    }

    private fun setupNutrientInputs() {
        // Calories
        val calView = findViewById<android.view.View>(R.id.input_calories)
        calView.findViewById<TextView>(R.id.nutrient_label).text = "CALORIES"
        calView.findViewById<TextView>(R.id.nutrient_unit).text = "kcal"

        // Protein
        val proteinView = findViewById<android.view.View>(R.id.input_protein)
        proteinView.findViewById<TextView>(R.id.nutrient_label).text = "PROTEIN"
        proteinView.findViewById<TextView>(R.id.nutrient_unit).text = "g"

        // Fat
        val fatView = findViewById<android.view.View>(R.id.input_fat)
        fatView.findViewById<TextView>(R.id.nutrient_label).text = "FAT"
        fatView.findViewById<TextView>(R.id.nutrient_unit).text = "g"

        // Carbs
        val carbsView = findViewById<android.view.View>(R.id.input_carbs)
        carbsView.findViewById<TextView>(R.id.nutrient_label).text = "CARBS"
        carbsView.findViewById<TextView>(R.id.nutrient_unit).text = "g"

        // Sugar
        val sugarView = findViewById<android.view.View>(R.id.input_sugar)
        sugarView.findViewById<TextView>(R.id.nutrient_label).text = "SUGAR"
        sugarView.findViewById<TextView>(R.id.nutrient_unit).text = "g"

        // Sodium
        val sodiumView = findViewById<android.view.View>(R.id.input_sodium)
        sodiumView.findViewById<TextView>(R.id.nutrient_label).text = "SODIUM"
        sodiumView.findViewById<TextView>(R.id.nutrient_unit).text = "mg"
    }

    private fun setupBottomNav() {
        val navContainer = findViewById<android.widget.LinearLayout>(R.id.bottom_navigation)
        
        val labels = listOf("Home", "Food", "Workout", "Progress", "Profile")
        val icons = listOf(
            android.R.drawable.ic_menu_today,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_media_play,
            android.R.drawable.ic_menu_sort_by_size,
            android.R.drawable.ic_menu_myplaces
        )

        for (i in 0 until navContainer.childCount) {
            val itemView = navContainer.getChildAt(i)
            itemView.findViewById<TextView>(R.id.nav_label).text = labels[i]
            itemView.findViewById<ImageView>(R.id.nav_icon).setImageResource(icons[i])
            
            if (i == 1) { // Food is selected
                itemView.findViewById<TextView>(R.id.nav_label).setTextColor(ContextCompat.getColor(this, R.color.primary_green))
                itemView.findViewById<ImageView>(R.id.nav_icon).setColorFilter(ContextCompat.getColor(this, R.color.primary_green))
                itemView.setBackgroundResource(R.drawable.bg_streak_badge) 
                itemView.backgroundTintList = android.content.res.ColorStateList.valueOf(ContextCompat.getColor(this, R.color.calorie_ring_bg))
            }

            itemView.setOnClickListener {
                if (i == 0) {
                    finish() // Go back to Home
                }
            }
        }
    }
}
