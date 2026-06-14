package com.example.gizigo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupSettings()
        setupBottomNav()
    }

    private fun setupSettings() {
        val container = findViewById<LinearLayout>(R.id.settings_container)
        
        val settings = listOf(
            Triple(android.R.drawable.ic_menu_myplaces, "Account details", false),
            Triple(android.R.drawable.ic_menu_recent_history, "Reminder settings", false),
            Triple(android.R.drawable.ic_popup_reminder, "Notification settings", false),
            Triple(android.R.drawable.ic_menu_view, "Dark mode", true)
        )

        for (i in 0 until container.childCount) {
            val itemView = container.getChildAt(i)
            if (itemView is LinearLayout) {
                val index = i / 2 // Accounts for separators
                if (index < settings.size) {
                    val (iconRes, title, hasSwitch) = settings[index]
                    itemView.findViewById<ImageView>(R.id.setting_icon).setImageResource(iconRes)
                    itemView.findViewById<TextView>(R.id.setting_title).text = title
                    
                    if (hasSwitch) {
                        itemView.findViewById<ImageView>(R.id.setting_arrow).visibility = android.view.View.GONE
                        itemView.findViewById<SwitchCompat>(R.id.setting_switch).visibility = android.view.View.VISIBLE
                    }
                }
            }
        }
    }

    private fun setupBottomNav() {
        val navContainer = findViewById<LinearLayout>(R.id.bottom_navigation)
        
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
            
            if (i == 4) { // Profile is selected
                itemView.findViewById<TextView>(R.id.nav_label).setTextColor(ContextCompat.getColor(this, R.color.primary_green))
                itemView.findViewById<ImageView>(R.id.nav_icon).setColorFilter(ContextCompat.getColor(this, R.color.primary_green))
                itemView.setBackgroundResource(R.drawable.bg_streak_badge) 
                itemView.backgroundTintList = android.content.res.ColorStateList.valueOf(ContextCompat.getColor(this, R.color.calorie_ring_bg))
            }

            itemView.setOnClickListener {
                when(i) {
                    0 -> {
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                    }
                    1 -> {
                        startActivity(Intent(this, AddFoodActivity::class.java))
                    }
                }
            }
        }
    }
}
