package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class CartFragmentDirections private constructor() {
  public companion object {
    public fun actionCartToLocation(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cart_to_location)

    public fun actionCartToPayment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cart_to_payment)
  }
}
