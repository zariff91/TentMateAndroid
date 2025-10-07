package com.example.tentmate.ui

import com.example.tentmate.R
import com.example.tentmate.data.Product
import com.example.tentmate.data.Repo
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
import com.example.tentmate.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)

        val adapter = ProductAdapter(Repo.products) { product ->
            val action = HomeFragmentDirections.actionHomeToDetails(product.id)
            findNavController().navigate(action)
        }
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter

        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.action_cart) {
                findNavController().navigate(R.id.action_home_to_cart)
                true
            } else false
        }
    }
    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}

class ProductAdapter(
    private val items: List<Product>,
    private val onClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductVH>() {
    override fun onCreateViewHolder(p: ViewGroup, vType: Int) =
        ProductVH(LayoutInflater.from(p.context).inflate(R.layout.item_product, p, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: ProductVH, pos: Int) = h.bind(items[pos], onClick)
}

class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
    private val img = view.findViewById<ImageView>(R.id.img)
    private val title = view.findViewById<TextView>(R.id.title)
    private val type = view.findViewById<TextView>(R.id.type)
    private val price = view.findViewById<TextView>(R.id.price)
    private val btn = view.findViewById<ImageButton>(R.id.btnView)

    fun bind(p: Product, onClick: (Product) -> Unit) {
        title.text = p.name
        type.text = p.type
        price.text = "RM ${p.pricePerDay}/day"
        img.load(p.imageRes)
        itemView.setOnClickListener { onClick(p) }
        btn.setOnClickListener { onClick(p) }
    }
}
