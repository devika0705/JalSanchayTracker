package com.example.jalsanchaytracker.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.jalsanchaytracker.R

public class SetupFragmentDirections private constructor() {
  public companion object {
    public fun actionSetupFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_setupFragment_to_homeFragment)
  }
}
