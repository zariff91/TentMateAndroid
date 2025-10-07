package com.example.tentmate.ui

import com.example.tentmate.R
import com.example.tentmate.data.Product
import com.example.tentmate.data.Repo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.tentmate.databinding.FragmentDetailsBinding
import com.example.tentmate.data.CartItem

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()
    private lateinit var product: Product

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailsBinding.bind(view)

        product = Repo.products.first { it.id == args.productId }
        binding.img.load(product.imageRes)
        binding.title.text = product.name
        binding.price.text = "RM ${product.pricePerDay}/day"

        binding.btnAddToCart.setOnClickListener {
            val days = binding.edtDays.text.toString().toIntOrNull() ?: 1
            Repo.cart.removeAll { it.product.id == product.id }
            Repo.cart.add(CartItem(product, days, 1))
            findNavController().navigate(R.id.action_details_to_cart)
        }
    }
    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}
