package com.example.tentmate.ui

import com.example.tentmate.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tentmate.data.Repo
import com.example.tentmate.databinding.FragmentChangeLocationBinding

class ChangeLocationFragment : Fragment(R.layout.fragment_change_location) {
    private var _binding: FragmentChangeLocationBinding? = null
    private val binding get() = _binding!!
    private val addresses = arrayListOf(
        "128 Main St, 47400 Petaling Jaya",
        "456 Market St, 52200 Setapak",
        "789 Commerce, 57000 Bukit Jalil",
        "Add new address…"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentChangeLocationBinding.bind(view)
        binding.list.adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1, addresses)

        binding.list.setOnItemClickListener { _, _, pos, _ ->
            if (pos == addresses.lastIndex) {
                Toast.makeText(requireContext(), "Open Add Address form", Toast.LENGTH_SHORT).show()
                return@setOnItemClickListener
            }
            Repo.selectedAddress = addresses[pos]
            findNavController().popBackStack()
        }
    }
    override fun onDestroyView() { _binding = null; super.onDestroyView() }
}
