package com.luka.splashpapers.misc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.luka.splashpapers.R
import com.luka.splashpapers.adapters.ViewPagerAdapter
import com.luka.splashpapers.base.BaseFragment
import com.luka.splashpapers.databinding.FragmentNavHostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostFragment : BaseFragment<FragmentNavHostBinding>(FragmentNavHostBinding::inflate) {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init() {
        viewPager = binding.viewPager
        tabLayout = binding.tabLayout

        val viewPagerFragmentAdapter = ViewPagerAdapter(activity as AppCompatActivity)
        viewPager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when (position) {
                0 -> {
                    tab.text = getString(R.string.tabNameHome)
                }
                1 -> {
                    tab.text = getString(R.string.tabNameCollections)
                }
            }
        }.attach()
    }
}
