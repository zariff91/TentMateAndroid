package com.example.tentmate.data

import com.example.tentmate.R

data class Product(
    val id: String,
    val name: String,
    val type: String,          // "Camping" or "Wedding"
    val pricePerDay: Int,
    val imageRes: Int,
    val specs: List<String> = emptyList()
)

data class CartItem(
    val product: Product,
    var days: Int,
    var qty: Int = 1
)

object Repo {
    val products = listOf(
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("1","Camping Tent","Camping",40,R.drawable.camping_tent,
            listOf("4-person","9' x 7'","Polyester","10 kg")),
        Product("2","Wedding Tent","Wedding",200,R.drawable.wedding_tent,
            listOf("40' x 90'","Polyester","100 kg"))
    )
    val cart = mutableListOf<CartItem>()
    var selectedAddress: String? = "128 Main St, 47400 PJ"
    var paymentMethod: String? = null
}
