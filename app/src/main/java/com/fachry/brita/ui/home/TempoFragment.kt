package com.fachry.brita.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fachry.brita.adapter.TempoPagerAdapter
import com.fachry.brita.databinding.FragmentTempoBinding
import com.google.android.material.tabs.TabLayoutMediator

class TempoFragment : Fragment() {

    private lateinit var binding: FragmentTempoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTempoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.vpTempo.adapter = TempoPagerAdapter(this)
        val tabList = arrayOf(
            "Teknologi",
            "Otomotif",
            "Sejarah"
        )

        val adapter = TempoPagerAdapter(this)
        binding.vpTempo.adapter = adapter

        TabLayoutMediator(binding.tabTempo, binding.vpTempo) { tab, position ->
            when (position) {
                0 -> tab.text = "Teknologi"
                1 -> tab.text = "Otomotif"
                2 -> tab.text = "Metro"
            }
        }.attach()
    }
}