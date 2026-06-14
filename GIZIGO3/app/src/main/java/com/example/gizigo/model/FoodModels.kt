package com.example.gizigo.model

data class FoodItem(
    val fdcId: Int,
    val description: String,
    val foodNutrients: List<FoodNutrient>
)

data class FoodNutrient(
    val name: String,
    val value: Double,
    val unitName: String
)
