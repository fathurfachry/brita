package com.fachry.brita.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fachry.brita.ui.detail.MerdekaAutoFragment
import com.fachry.brita.ui.detail.MerdekaWorldFragment
import com.fachry.brita.ui.detail.MerdekaTechFragment
import com.fachry.brita.ui.home.MerdekaFragment

class MerdekaPagerAdapter(fa: MerdekaFragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MerdekaTechFragment()
            1 -> MerdekaAutoFragment()
            2 -> MerdekaWorldFragment()
            else -> MerdekaTechFragment()
        }
    }

}