package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class PaymentFragmentDirections private constructor() {
  public companion object {
    public fun actionPaymentToCheckout(): NavDirections =
        ActionOnlyNavDirections(R.id.action_payment_to_checkout)
  }
}
