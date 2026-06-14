package com.example.gizigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingFragment : Fragment() {

    private var pagePosition = 0
    private lateinit var listener: OnboardingListener

    interface OnboardingListener {
        fun onSkipClicked()
        fun onNextClicked()
    }

    companion object {
        private const val ARG_PAGE_POSITION = "page_position"

        fun newInstance(position: Int, listener: OnboardingListener): OnboardingFragment {
            return OnboardingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PAGE_POSITION, position)
                }
                this.listener = listener
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagePosition = arguments?.getInt(ARG_PAGE_POSITION) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSkip = view.findViewById<TextView>(R.id.tv_skip)
        val btnNext = view.findViewById<Button>(R.id.btn_next)
        val tvScreenTitle = view.findViewById<TextView>(R.id.tv_screen_title)
        val tvScreenDesc = view.findViewById<TextView>(R.id.tv_screen_desc)
        val tvMealType = view.findViewById<TextView>(R.id.tv_meal_type)
        val tvMealTitle = view.findViewById<TextView>(R.id.tv_meal_title)
        val dot1 = view.findViewById<View>(R.id.dot_1)
        val dot2 = view.findViewById<View>(R.id.dot_2)
        val dot3 = view.findViewById<View>(R.id.dot_3)

        // Update content based on page position
        when (pagePosition) {
            0 -> {
                tvScreenTitle.text = getString(R.string.track_calories_title)
                tvScreenDesc.text = getString(R.string.track_calories_desc)
                tvMealType.text = getString(R.string.breakfast)
                tvMealTitle.text = getString(R.string.oatmeal_bowl)
                updateDots(dot1, dot2, dot3, 0)
            }
            1 -> {
                tvScreenTitle.text = getString(R.string.meal_plan_title)
                tvScreenDesc.text = getString(R.string.meal_plan_desc)
                tvMealType.text = "LUNCH"
                tvMealTitle.text = "Grilled Chicken"
                updateDots(dot1, dot2, dot3, 1)
            }
            2 -> {
                tvScreenTitle.text = getString(R.string.fitness_title)
                tvScreenDesc.text = getString(R.string.fitness_desc)
                tvMealType.text = "DINNER"
                tvMealTitle.text = "Salmon Bowl"
                updateDots(dot1, dot2, dot3, 2)
                btnNext.text = "Get Started"
            }
        }

        tvSkip.setOnClickListener {
            listener.onSkipClicked()
        }

        btnNext.setOnClickListener {
            listener.onNextClicked()
        }
    }

    private fun updateDots(dot1: View, dot2: View, dot3: View, position: Int) {
        val activeDrawable = R.drawable.dot_active
        val inactiveDrawable = R.drawable.dot_inactive

        dot1.background = resources.getDrawable(if (position == 0) activeDrawable else inactiveDrawable, null)
        dot2.background = resources.getDrawable(if (position == 1) activeDrawable else inactiveDrawable, null)
        dot3.background = resources.getDrawable(if (position == 2) activeDrawable else inactiveDrawable, null)
    }

    fun setListener(listener: OnboardingListener) {
        this.listener = listener
    }
}

