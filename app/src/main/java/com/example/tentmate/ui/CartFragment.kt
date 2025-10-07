package com.example.tentmate.ui

import com.example.tentmate.R
import com.example.tentmate.data.Repo
import com.example.tentmate.data.CartItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tentmate.databinding.FragmentCartBinding

class CartFragment : Fragment(R.layout.fragment_cart) {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCartBinding.bind(view)

        val adapter = CartAdapter(Repo.cart,
            onPlus = { id -> Repo.cart.find { it.product.id == id }?.apply { qty++ }; refresh() },
            onMinus = { id -> Repo.cart.find { it.product.id == id }?.apply { if (qty > 1) qty-- }; refresh() }
        )
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter

        binding.btnChangeLocation.setOnClickListener {
            findNavController().navigate(R.id.action_cart_to_location)
        }

        binding.btnCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_cart_to_payment)
        }

        refresh()
    }

    private fun refresh() {
        binding.txtAddress.text = Repo.selectedAddress ?: "No address"
        val total = Repo.cart.sumOf { it.product.pricePerDay * it.days * it.qty }
        binding.txtTotal.text = "RM $total"
        binding.rv.adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}

class CartAdapter(
    private val items: List<CartItem>,
    private val onPlus: (String) -> Unit,
    private val onMinus: (String) -> Unit
) : RecyclerView.Adapter<CartVH>() {
    override fun onCreateViewHolder(p: ViewGroup, v: Int) =
        CartVH(LayoutInflater.from(p.context).inflate(R.layout.item_cart, p, false), onPlus, onMinus)
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: CartVH, pos: Int) = h.bind(items[pos])
}

class CartVH(view: View,
             private val onPlus: (String) -> Unit,
             private val onMinus: (String) -> Unit
) : RecyclerView.ViewHolder(view) {
    private val img = view.findViewById<ImageView>(R.id.img)
    private val title = view.findViewById<TextView>(R.id.title)
    private val days = view.findViewById<TextView>(R.id.days)
    private val price = view.findViewById<TextView>(R.id.price)
    private val qty = view.findViewById<TextView>(R.id.qty)
    private val btnPlus = view.findViewById<ImageButton>(R.id.btnPlus)
    private val btnMinus = view.findViewById<ImageButton>(R.id.btnMinus)

    fun bind(ci: CartItem) {
        img.load(ci.product.imageRes)
        title.text = ci.product.name
        days.text = "${ci.days} day(s)"
        price.text = "RM ${ci.product.pricePerDay * ci.days}"
        qty.text = ci.qty.toString()
        btnPlus.setOnClickListener { onPlus(ci.product.id) }
        btnMinus.setOnClickListener { onMinus(ci.product.id) }
    }
}
