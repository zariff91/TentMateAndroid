package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class CheckoutFragmentDirections private constructor() {
  public companion object {
    public fun actionCheckoutToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_checkout_to_home)
  }
}
