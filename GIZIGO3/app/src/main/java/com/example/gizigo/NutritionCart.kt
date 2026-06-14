package com.example.gizigo

object NutritionCart {
    data class CartItem(
        val name: String,
        val caloriesPerUnit: Int,
        var quantity: Int,
        val protein: Double,
        val carbs: Double,
        val fat: Double
    )

    val selectedItems = mutableListOf<CartItem>()

    fun addItem(name: String, calories: Int, p: Double, c: Double, f: Double) {
        val existing = selectedItems.find { it.name == name }
        if (existing != null) {
            existing.quantity++
        } else {
            selectedItems.add(CartItem(name, calories, 1, p, c, f))
        }
    }

    fun removeItem(name: String) {
        selectedItems.removeAll { it.name == name }
    }

    fun updateQuantity(name: String, delta: Int) {
        val item = selectedItems.find { it.name == name }
        if (item != null) {
            item.quantity += delta
            if (item.quantity <= 0) {
                selectedItems.remove(item)
            }
        }
    }

    fun getTotalCalories(): Double = selectedItems.sumOf { it.caloriesPerUnit * it.quantity }.toDouble()
    fun getTotalProtein(): Double = selectedItems.sumOf { it.protein * it.quantity }
    fun getTotalCarbs(): Double = selectedItems.sumOf { it.carbs * it.quantity }
    fun getTotalFat(): Double = selectedItems.sumOf { it.fat * it.quantity }
}
