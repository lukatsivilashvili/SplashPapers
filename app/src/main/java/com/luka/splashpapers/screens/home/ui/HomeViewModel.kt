package com.luka.splashpapers.screens.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luka.splashpapers.screens.home.models.HomeModelFace
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem
import com.luka.splashpapers.screens.home.repository.HomePhotosRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val recentPhotosRepoImplement: HomePhotosRepoImplement) :
    ViewModel() {

    private val photosLiveData = MutableLiveData<List<HomeModelFace>>()
    val _photosLiveData: LiveData<List<HomeModelFace>> = photosLiveData

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    fun obtainRecentPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            loadingLiveData.postValue(true)
            val photos = recentPhotosRepoImplement.getRecentPhotos()
            val items = photos.data
            val fin = transformToFace(items)
            photosLiveData.postValue(fin!!)
            loadingLiveData.postValue(false)
        }

    }

    private fun transformToFace(homePaginatedModelItems: List<HomePaginatedModelItem>?): List<HomeModelFace>? {
        return homePaginatedModelItems?.map { HomePaginatedModelItem ->
            HomeModelFace(
                urls = HomePaginatedModelItem.urls,
                likes = HomePaginatedModelItem.likes,
                colors = HomePaginatedModelItem.color
            )
        }
    }

}