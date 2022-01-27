package com.luka.splashpapers.screens.home.ui

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luka.splashpapers.screens.home.models.HomePaginatedModel
import com.luka.splashpapers.screens.home.repository.RecentPhotosRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val recentPhotosRepoImplement: RecentPhotosRepoImplement) : ViewModel() {

    private val photosLiveData = MutableLiveData<HomePaginatedModel>()
    val _photosLiveData: LiveData<HomePaginatedModel> = photosLiveData

    fun init(){
        CoroutineScope(Dispatchers.IO).launch {
            obtainRecentPhotos()
        }
    }

    private suspend fun obtainRecentPhotos(){
        val photos = recentPhotosRepoImplement.getRecentPhotos()
        val items = photos.data
        photosLiveData.postValue(items!!)
        delay(2000)
        d("myLog", _photosLiveData.value.toString())
    }

}