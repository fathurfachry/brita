package com.fachry.brita.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fachry.brita.ui.detail.CNNEntertainmentFragment
import com.fachry.brita.ui.detail.CNNEconomyFragment
import com.fachry.brita.ui.detail.CNNTechFragment

class CNNPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CNNTechFragment()
            1 -> CNNEntertainmentFragment()
            2 -> CNNEconomyFragment()
            else -> CNNTechFragment()
        }
    }
}