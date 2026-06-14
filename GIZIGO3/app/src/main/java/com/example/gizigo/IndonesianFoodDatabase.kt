package com.example.gizigo

object IndonesianFoodDatabase {

    val foods: List<NutritionCart.FoodItem> = listOf(
        // === MAKANAN POKOK ===
        food("Nasi Putih (1 centong ~100g)", 130, 2.7, 28.0, 0.3),
        food("Nasi Goreng (1 porsi ~200g)", 260, 6.0, 38.0, 9.0),
        food("Nasi Uduk (1 porsi ~150g)", 210, 4.0, 35.0, 6.0),
        food("Nasi Kuning (1 porsi ~150g)", 195, 3.5, 34.0, 5.0),
        food("Lontong (2 potong ~100g)", 100, 2.0, 22.0, 0.5),
        food("Ketupat (1 buah ~85g)", 85, 1.5, 19.0, 0.3),
        food("Bubur Ayam (1 mangkok ~300g)", 180, 10.0, 28.0, 3.5),
        food("Mie Goreng (1 porsi ~200g)", 330, 8.0, 45.0, 13.0),
        food("Mie Rebus (1 porsi ~200g)", 240, 7.0, 38.0, 6.0),
        food("Bihun Goreng (1 porsi ~150g)", 255, 5.0, 42.0, 7.0),

        // === LAUK PAUK ===
        food("Ayam Goreng (1 potong ~100g)", 246, 27.0, 0.0, 15.0),
        food("Ayam Bakar (1 potong ~100g)", 195, 28.0, 2.0, 8.0),
        food("Rendang Sapi (1 potong ~75g)", 210, 22.0, 4.0, 12.0),
        food("Ikan Goreng (1 ekor sedang ~100g)", 195, 24.0, 0.0, 10.0),
        food("Ikan Bakar (1 ekor sedang ~100g)", 155, 25.0, 0.0, 5.5),
        food("Telur Goreng (1 butir)", 92, 6.3, 0.4, 7.2),
        food("Telur Rebus (1 butir)", 78, 6.3, 0.6, 5.3),
        food("Telur Dadar (1 butir)", 95, 6.5, 0.5, 7.5),
        food("Tempe Goreng (1 potong ~50g)", 100, 9.0, 5.0, 5.5),
        food("Tempe Bacem (1 potong ~50g)", 115, 8.5, 10.0, 5.0),
        food("Tahu Goreng (1 potong ~60g)", 85, 7.0, 2.0, 5.5),
        food("Tahu Bacem (1 potong ~60g)", 95, 7.5, 6.0, 5.0),
        food("Bakso (5 butir ~100g)", 175, 14.0, 10.0, 8.0),
        food("Sate Ayam (5 tusuk ~100g)", 210, 22.0, 5.0, 11.0),
        food("Sate Kambing (5 tusuk ~100g)", 225, 23.0, 3.0, 13.0),
        food("Ikan Tuna Kaleng (1/2 kaleng ~85g)", 130, 25.0, 0.0, 3.0),
        food("Udang Goreng (5 ekor ~75g)", 140, 18.0, 2.0, 6.5),

        // === SAYURAN ===
        food("Sayur Bayam (1 mangkok ~100g)", 36, 3.5, 3.6, 0.7),
        food("Tumis Kangkung (1 porsi ~100g)", 55, 2.5, 4.0, 3.0),
        food("Capcay (1 porsi ~150g)", 85, 4.0, 8.0, 4.0),
        food("Sayur Asem (1 mangkok ~200g)", 70, 3.0, 12.0, 1.0),
        food("Tumis Buncis (1 porsi ~100g)", 65, 2.5, 7.0, 3.0),
        food("Sup Sayuran (1 mangkok ~250g)", 75, 3.5, 10.0, 2.0),
        food("Lalapan (timun+tomat+selada ~100g)", 30, 1.5, 5.5, 0.3),
        food("Terong Balado (1 porsi ~100g)", 80, 2.0, 7.0, 5.0),

        // === MAKANAN BERKUAH ===
        food("Soto Ayam (1 mangkok ~300g)", 215, 18.0, 12.0, 9.0),
        food("Sop Buntut (1 mangkok ~300g)", 285, 22.0, 8.0, 18.0),
        food("Rawon (1 mangkok ~300g)", 260, 20.0, 10.0, 15.0),
        food("Opor Ayam (1 porsi ~200g)", 290, 22.0, 6.0, 20.0),
        food("Gado-gado (1 porsi ~250g)", 310, 14.0, 25.0, 18.0),
        food("Pecel (1 porsi ~200g)", 265, 11.0, 22.0, 15.0),

        // === BUAH-BUAHAN ===
        food("Pisang Ambon (1 buah ~100g)", 99, 1.1, 23.0, 0.3),
        food("Pisang Goreng (1 buah ~80g)", 145, 1.5, 25.0, 4.5),
        food("Mangga (1/2 buah ~150g)", 98, 1.4, 24.5, 0.4),
        food("Pepaya (1 potong ~150g)", 65, 0.9, 15.0, 0.4),
        food("Semangka (2 potong ~200g)", 60, 1.2, 15.0, 0.3),
        food("Jeruk (1 buah ~130g)", 60, 1.2, 15.0, 0.2),
        food("Apel (1 buah ~150g)", 78, 0.4, 21.0, 0.2),
        food("Melon (2 potong ~200g)", 64, 1.0, 16.0, 0.3),
        food("Alpukat (1/2 buah ~75g)", 120, 1.5, 6.0, 11.0),

        // === CAMILAN & JAJANAN ===
        food("Gorengan Bakwan (1 buah ~60g)", 145, 3.5, 16.0, 7.5),
        food("Martabak Telur (1 potong ~100g)", 265, 12.0, 22.0, 14.0),
        food("Risoles (1 buah ~70g)", 155, 5.0, 18.0, 7.0),
        food("Roti Tawar (2 lembar ~60g)", 158, 5.4, 29.0, 2.2),
        food("Kerupuk (5 keping ~15g)", 72, 0.8, 12.0, 2.0),

        // === MINUMAN ===
        food("Es Teh Manis (1 gelas ~250ml)", 90, 0.1, 22.0, 0.0),
        food("Jus Alpukat (1 gelas ~300ml)", 235, 3.0, 24.0, 14.0),
        food("Jus Jeruk (1 gelas ~250ml)", 112, 1.7, 26.0, 0.5),
        food("Susu Sapi (1 gelas ~200ml)", 122, 6.4, 9.6, 4.8),
        food("Kopi Susu (1 gelas ~200ml)", 85, 2.5, 10.0, 3.5)
    )

    private fun food(name: String, cal: Int, p: Double, c: Double, f: Double): NutritionCart.FoodItem {
        return NutritionCart.FoodItem(name, cal, p, c, f)
    }

    fun search(query: String): List<NutritionCart.FoodItem> {
        if (query.isBlank()) return emptyList()
        val q = query.lowercase().trim()
        return foods.filter { it.name.lowercase().contains(q) }
    }
}
