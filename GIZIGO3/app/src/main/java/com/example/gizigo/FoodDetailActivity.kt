package com.example.gizigo

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        setupIngredients()
        setupAlternatives()
    }

    private fun setupIngredients() {
        val ingredientsList = findViewById<LinearLayout>(R.id.ingredients_list)
        val ingredients = listOf(
            "Fresh grilled salmon fillet",
            "Organic baby spinach",
            "Hass avocado slices",
            "Red quinoa",
            "Cold-pressed olive oil"
        )

        val inflater = LayoutInflater.from(this)
        ingredients.forEach { name ->
            val itemView = inflater.inflate(R.layout.item_ingredient, ingredientsList, false)
            itemView.findViewById<TextView>(R.id.ingredient_name).text = name
            ingredientsList.addView(itemView)
        }
    }

    private fun setupAlternatives() {
        val container = findViewById<LinearLayout>(R.id.alternatives_container)
        val inflater = LayoutInflater.from(this)
        
        // Use existing item_recommended layout for alternatives
        val alternatives = listOf(
            "Vegan Buddha Bowl" to "Higher fiber content",
            "Seared Salmon" to "Healthy fats priority"
        )

        alternatives.forEach { (title, subtitle) ->
            val itemView = inflater.inflate(R.layout.item_recommended, container, false)
            itemView.findViewById<TextView>(R.id.rec_title).text = title
            itemView.findViewById<TextView>(R.id.rec_subtitle).text = subtitle
            container.addView(itemView)
        }
    }
}
