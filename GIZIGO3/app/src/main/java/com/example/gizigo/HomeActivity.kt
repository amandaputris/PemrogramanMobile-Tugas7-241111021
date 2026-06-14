package com.example.gizigo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupNutrients()
        setupQuickActions()
        setupBottomNav()
    }

    private fun setupNutrients() {
        // Protein
        val proteinView = findViewById<androidx.cardview.widget.CardView>(R.id.card_protein)
        proteinView.findViewById<TextView>(R.id.nutrient_label).text = "PROTEIN"
        proteinView.findViewById<TextView>(R.id.nutrient_value).text = "92g / 150g"
        proteinView.findViewById<TextView>(R.id.nutrient_percentage).text = "62%"
        proteinView.findViewById<ImageView>(R.id.nutrient_icon).apply {
            setImageResource(android.R.drawable.ic_menu_compass)
            setColorFilter(ContextCompat.getColor(this@HomeActivity, R.color.protein_color))
        }

        // Carbs
        val carbsView = findViewById<androidx.cardview.widget.CardView>(R.id.card_carbs)
        carbsView.findViewById<TextView>(R.id.nutrient_label).text = "CARBS"
        carbsView.findViewById<TextView>(R.id.nutrient_value).text = "112g / 250g"
        carbsView.findViewById<TextView>(R.id.nutrient_percentage).text = "45%"
        carbsView.findViewById<ImageView>(R.id.nutrient_icon).apply {
            setImageResource(android.R.drawable.ic_menu_gallery) // Placeholder
            setColorFilter(ContextCompat.getColor(this@HomeActivity, R.color.carbs_color))
        }

        // Fat
        val fatView = findViewById<androidx.cardview.widget.CardView>(R.id.card_fat)
        fatView.findViewById<TextView>(R.id.nutrient_label).text = "FAT"
        fatView.findViewById<TextView>(R.id.nutrient_value).text = "54g / 70g"
        fatView.findViewById<TextView>(R.id.nutrient_percentage).text = "78%"
        fatView.findViewById<ImageView>(R.id.nutrient_icon).apply {
            setImageResource(android.R.drawable.ic_menu_camera) // Placeholder
            setColorFilter(ContextCompat.getColor(this@HomeActivity, R.color.fat_color))
        }

        // Water
        val waterView = findViewById<androidx.cardview.widget.CardView>(R.id.card_water)
        waterView.findViewById<TextView>(R.id.nutrient_label).text = "WATER"
        waterView.findViewById<TextView>(R.id.nutrient_value).text = "1.2L / 3.0L"
        waterView.findViewById<TextView>(R.id.nutrient_percentage).text = "40%"
        waterView.findViewById<ImageView>(R.id.nutrient_icon).apply {
            setImageResource(android.R.drawable.ic_menu_day) // Placeholder
            setColorFilter(ContextCompat.getColor(this@HomeActivity, R.color.water_color))
        }
    }

    private fun setupQuickActions() {
        val addFood = findViewById<android.widget.LinearLayout>(R.id.action_add_food)
        addFood.findViewById<TextView>(R.id.action_label).text = "Add Food"
        addFood.findViewById<ImageView>(R.id.action_icon).setImageResource(android.R.drawable.ic_input_add)

        val scanLabel = findViewById<android.widget.LinearLayout>(R.id.action_scan_label)
        scanLabel.findViewById<TextView>(R.id.action_label).text = "Scan Label"
        scanLabel.findViewById<ImageView>(R.id.action_icon).setImageResource(android.R.drawable.ic_menu_camera)

        val workout = findViewById<android.widget.LinearLayout>(R.id.action_workout)
        workout.findViewById<TextView>(R.id.action_label).text = "Workout"
        workout.findViewById<ImageView>(R.id.action_icon).setImageResource(android.R.drawable.ic_media_play)

        val insights = findViewById<android.widget.LinearLayout>(R.id.action_insights)
        insights.findViewById<TextView>(R.id.action_label).text = "Insights"
        insights.findViewById<ImageView>(R.id.action_icon).setImageResource(android.R.drawable.ic_menu_sort_by_size)
    }

    private fun setupBottomNav() {
        // This is a simplified bottom nav setup as per the design
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
            
            if (i == 0) { // Home is selected
                itemView.findViewById<TextView>(R.id.nav_label).setTextColor(ContextCompat.getColor(this, R.color.primary_green))
                itemView.findViewById<ImageView>(R.id.nav_icon).setColorFilter(ContextCompat.getColor(this, R.color.primary_green))
                itemView.setBackgroundResource(R.drawable.bg_streak_badge) // light green-ish bg for selected
                itemView.backgroundTintList = ContextCompat.getColorStateList(this, R.color.calorie_ring_bg)
            }
        }
    }
}
