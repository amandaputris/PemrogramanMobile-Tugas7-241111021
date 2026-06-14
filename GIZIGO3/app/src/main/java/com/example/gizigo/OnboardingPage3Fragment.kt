package com.example.gizigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingPage3Fragment : Fragment() {

    private lateinit var listener: OnboardingListener

    interface OnboardingListener {
        fun onSkipClicked()
        fun onNextClicked()
    }

    companion object {
        fun newInstance(listener: OnboardingListener): OnboardingPage3Fragment {
            return OnboardingPage3Fragment().apply {
                this.listener = listener
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.btn_next)
        val tvSkip = view.findViewById<TextView>(R.id.tv_skip)

        btnNext.setOnClickListener {
            listener.onNextClicked()
        }

        tvSkip.setOnClickListener {
            listener.onSkipClicked()
        }
    }

    fun setListener(listener: OnboardingListener) {
        this.listener = listener
    }
}

