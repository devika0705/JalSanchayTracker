package com.example.jalsanchaytracker.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.jalsanchaytracker.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)

    public fun actionSplashFragmentToSetupFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_setupFragment)
  }
}
