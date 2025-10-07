package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class DetailsFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailsToCart(): NavDirections =
        ActionOnlyNavDirections(R.id.action_details_to_cart)
  }
}
