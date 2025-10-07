package com.example.tentmate.ui

import com.example.tentmate.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tentmate.data.Repo
import com.example.tentmate.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment(R.layout.fragment_payment) {
    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    private var method: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPaymentBinding.bind(view)
        binding.optCard.setOnClickListener { select("Credit Card") }
        binding.optCod.setOnClickListener { select("Cash on Delivery") }
        binding.btnProceed.setOnClickListener {
            Repo.paymentMethod = method ?: "Cash on Delivery"
            findNavController().navigate(R.id.action_payment_to_checkout)
        }
    }

    private fun select(m: String) {
        method = m
        binding.optCard.isChecked = m == "Credit Card"
        binding.optCod.isChecked = m == "Cash on Delivery"
    }
    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}
