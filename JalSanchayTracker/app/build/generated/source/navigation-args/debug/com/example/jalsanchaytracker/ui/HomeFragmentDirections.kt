package com.example.jalsanchaytracker.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.jalsanchaytracker.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToEntryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_entryFragment)

    public fun actionHomeFragmentToHistoryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_historyFragment)

    public fun actionHomeFragmentToReportFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_reportFragment)

    public fun actionHomeFragmentToTipsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_tipsFragment)

    public fun actionHomeFragmentToSetupFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_setupFragment)
  }
}
