package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class ChangeLocationFragmentDirections private constructor() {
  public companion object {
    public fun actionLocationBackToCart(): NavDirections =
        ActionOnlyNavDirections(R.id.action_location_back_to_cart)
  }
}
