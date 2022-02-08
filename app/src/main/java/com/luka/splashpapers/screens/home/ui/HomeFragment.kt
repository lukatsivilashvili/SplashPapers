package com.luka.splashpapers.screens.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.luka.splashpapers.base.BaseFragment
import com.luka.splashpapers.databinding.HomeFragmentBinding
import com.luka.splashpapers.screens.home.adapters.HomePhotosRecyclerAdapter
import com.luka.splashpapers.utils.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var myAdapter: HomePhotosRecyclerAdapter

    override fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init() {
        initRecycler()
        setObservers()
        setListeners()
    }


    private fun initRecycler() {
        myAdapter = HomePhotosRecyclerAdapter(object : OnItemClickListener {
            override fun clickItem(position: Int, id: String) {
                Toast.makeText(requireContext(), id, Toast.LENGTH_SHORT).show()
            }

        })
        binding.recycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = myAdapter
        }
    }

    private fun setObservers() {
        viewModel.photosList.observe(viewLifecycleOwner) {
            myAdapter.submitData(lifecycle, it)
        }
    }

    private fun setListeners() {
        binding.refresh.setOnRefreshListener {
            myAdapter.refresh()
        }

        myAdapter.addLoadStateListener {
            binding.refresh.isRefreshing = it.refresh is LoadState.Loading
        }
    }
}