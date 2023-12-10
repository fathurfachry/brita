package com.fachry.brita.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fachry.brita.adapter.CNNPagerAdapter
import com.fachry.brita.databinding.FragmentCNNBinding
import com.google.android.material.tabs.TabLayoutMediator

class CNNFragment : Fragment() {

    private lateinit var binding: FragmentCNNBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCNNBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {

        val adapter = CNNPagerAdapter(requireActivity())
        binding.vpCnn.adapter = adapter

        TabLayoutMediator(binding.tabCnn, binding.vpCnn) { tab, position ->
            when (position) {
                0 -> tab.text = "Teknologi"
                1 -> tab.text = "Hiburan"
                2 -> tab.text = "Ekonomi"
            }
        }.attach()
    }
}