package com.fachry.brita.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fachry.brita.ui.detail.TempoAutoFragment
import com.fachry.brita.ui.detail.TempoMetroFragment
import com.fachry.brita.ui.detail.TempoTechFragment
import com.fachry.brita.ui.home.TempoFragment

class TempoPagerAdapter(fa: TempoFragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TempoTechFragment()
            1 -> TempoAutoFragment()
            2 -> TempoMetroFragment()
            else -> TempoTechFragment()
        }
    }

}