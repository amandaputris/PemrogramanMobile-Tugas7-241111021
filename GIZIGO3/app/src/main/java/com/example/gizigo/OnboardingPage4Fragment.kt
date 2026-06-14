package com.example.gizigo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class OnboardingPage4Fragment : Fragment() {

    private var listener: OnboardingListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listener = it.getSerializable("listener") as? OnboardingListener
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_page4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getStartedBtn = view.findViewById<Button>(R.id.getStartedBtn)
        getStartedBtn.setOnClickListener {
            listener?.onNextClicked()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(listener: OnboardingListener) =
            OnboardingPage4Fragment().apply {
                arguments = Bundle().apply {
                    putSerializable("listener", listener as java.io.Serializable)
                }
            }
    }
}

