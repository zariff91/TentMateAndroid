package com.example.tentmate.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tentmate.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_login_to_home)
  }
}
