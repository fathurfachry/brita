package com.fachry.brita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fachry.brita.adapter.MainPagerAdapter
import com.fachry.brita.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Set icon untuk tab yang dipilih
                tab.icon = when (tab.position) {
                    0 -> resources.getDrawable(R.drawable.logo_antara)
                    1 -> resources.getDrawable(R.drawable.logo_tempo)
                    2 -> resources.getDrawable(R.drawable.logo_cnn)
                    else -> null
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Set icon untuk tab yang tidak dipilih
                tab.icon = when (tab.position) {
                    0 -> resources.getDrawable(R.drawable.logo_antara)
                    1 -> resources.getDrawable(R.drawable.logo_tempo)
                    2 -> resources.getDrawable(R.drawable.logo_cnn)
                    else -> null
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.icon = when (tab?.position) {
                    0 -> resources.getDrawable(R.drawable.logo_antara)
                    1 -> resources.getDrawable(R.drawable.logo_tempo)
                    2 -> resources.getDrawable(R.drawable.logo_cnn)
                    else -> null
                }
            }
        })

//        binding.tabMain.setTabIconSize(50)

        setupVP()
    }

    private fun setupVP() {
        binding.vpMain.adapter = MainPagerAdapter(this)
        val tabList = arrayOf(
            "Merdeka",
            "Tempo",
            "CNN"
        )

        val adapter = MainPagerAdapter(this)
        binding.vpMain.adapter = adapter

        TabLayoutMediator(binding.tabMain, binding.vpMain) { tab, position ->
            when (position) {
                0 -> resources.getDrawable(R.drawable.logo_antara)
                1 -> resources.getDrawable(R.drawable.logo_tempo)
                2 -> resources.getDrawable(R.drawable.logo_cnn)
                else -> null
            }
        }.attach()
    }
}