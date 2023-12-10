package com.fachry.brita.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fachry.brita.MainActivity
import com.fachry.brita.ui.home.CNNFragment
import com.fachry.brita.ui.home.MerdekaFragment
import com.fachry.brita.ui.home.TempoFragment

class MainPagerAdapter(fa: MainActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MerdekaFragment()
            1 -> TempoFragment()
            2 -> CNNFragment()
            else -> MerdekaFragment()
        }
    }

}