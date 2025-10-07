package com.example.tentmate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tentmate.R

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.btnGetStarted).setOnClickListener {
            findNavController().navigate(R.id.action_login_to_home)
        }
        // For now both Skip and Log In just continue to Home
        view.findViewById<View>(R.id.btnSkip).setOnClickListener {
            findNavController().navigate(R.id.action_login_to_home)
        }
        view.findViewById<View>(R.id.btnLoginLink).setOnClickListener {
            findNavController().navigate(R.id.action_login_to_home)
        }
    }
}
