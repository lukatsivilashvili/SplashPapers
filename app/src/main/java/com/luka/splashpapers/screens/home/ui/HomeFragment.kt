package com.luka.splashpapers.screens.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.luka.splashpapers.base.BaseFragment
import com.luka.splashpapers.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {
    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
    }
}