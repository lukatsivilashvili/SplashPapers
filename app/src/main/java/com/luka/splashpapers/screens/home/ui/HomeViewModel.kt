package com.luka.splashpapers.screens.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.luka.splashpapers.screens.home.adapters.HomePhotosPagingDataSource
import com.luka.splashpapers.screens.home.repository.HomePhotosRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recentPhotosRepoImplement: HomePhotosRepoImplement
) : ViewModel() {

    val photosList = Pager(PagingConfig(pageSize = 40)) {
        HomePhotosPagingDataSource(recentPhotosRepoImplement)
    }.liveData.cachedIn(viewModelScope)
}