package com.example.gizigo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity(), OnboardingFragment.OnboardingListener {

    private lateinit var viewPager2: ViewPager2
    private val totalPages = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.adapter = OnboardingAdapter(this, this)
    }

    override fun onSkipClicked() {
        // Go to MainActivity
        navigateToMainActivity()
    }

    override fun onNextClicked() {
        val currentPosition = viewPager2.currentItem
        if (currentPosition < totalPages - 1) {
            viewPager2.currentItem = currentPosition + 1
        } else {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        // Navigate to MainActivity
        val intent = android.content.Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

class OnboardingAdapter(
    fragmentActivity: FragmentActivity,
    private val listener: OnboardingFragment.OnboardingListener
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment.newInstance(position, listener)
    }
}

