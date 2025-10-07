package com.example.tentmate.ui

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R
import kotlin.Int
import kotlin.String

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeToDetails(
    public val productId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_home_to_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        return result
      }
  }

  public companion object {
    public fun actionHomeToDetails(productId: String): NavDirections =
        ActionHomeToDetails(productId)

    public fun actionHomeToCart(): NavDirections = ActionOnlyNavDirections(R.id.action_home_to_cart)
  }
}
