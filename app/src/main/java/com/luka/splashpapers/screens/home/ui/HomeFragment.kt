package com.luka.splashpapers.screens.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.luka.splashpapers.adapters.HomePhotosRecyclerAdapter
import com.luka.splashpapers.base.BaseFragment
import com.luka.splashpapers.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var myAdapter: HomePhotosRecyclerAdapter

    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init() {
        viewModel.init()
        initRecycler()
        observe()

        binding.refresh.setOnRefreshListener {
            myAdapter.clearData()
            viewModel.init()
        }
    }


    private fun initRecycler() {
        myAdapter = HomePhotosRecyclerAdapter()
        binding.recycler.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.recycler.adapter = myAdapter
    }

    private fun observe() {
        viewModel._loadingLiveData.observe(viewLifecycleOwner) {
            binding.refresh.isRefreshing = it
        }

        viewModel._photosLiveData.observe(viewLifecycleOwner) {
            myAdapter.setData(it.toMutableList())
        }
    }
}