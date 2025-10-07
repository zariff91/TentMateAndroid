package com.example.tentmate.ui

import com.example.tentmate.R
import com.example.tentmate.data.Repo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tentmate.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment(R.layout.fragment_checkout) {
    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCheckoutBinding.bind(view)
        val total = Repo.cart.sumOf { it.product.pricePerDay * it.days * it.qty }
        val address = Repo.selectedAddress ?: "N/A"
        val method = Repo.paymentMethod ?: "N/A"
        binding.summary.text = "Total: RM %d\nAddress: %s\nPayment: %s".format(total, address, method)

        binding.btnBackHome.setOnClickListener {
            Repo.cart.clear()
            findNavController().navigate(R.id.action_checkout_to_home)
        }
    }
    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}
