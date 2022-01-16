package com.luka.splashpapers.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.luka.splashpapers.screens.collections.ui.CollectionsFragment
import com.luka.splashpapers.screens.home.ui.HomeFragment

class ViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> CollectionsFragment()
            else -> HomeFragment()
        }
    }
}