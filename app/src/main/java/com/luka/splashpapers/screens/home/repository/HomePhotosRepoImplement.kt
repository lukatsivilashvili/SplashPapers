package com.luka.splashpapers.screens.home.repository

import com.luka.splashpapers.misc.NetworkHandler
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem
import com.luka.splashpapers.screens.home.service.RecentPhotosService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomePhotosRepoImplement @Inject constructor(private val recentPhotosService: RecentPhotosService) :
    HomePhotosRepo {
    override suspend fun getRecentPhotos(page:Int): NetworkHandler<List<HomePaginatedModelItem>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = recentPhotosService.getRecentPhotos(page)
                if (result.isSuccessful) {
                    NetworkHandler.Success(result.body()!!)
                } else {
                    NetworkHandler.Error(result.errorBody().toString())
                }
            } catch (e: Exception) {
                NetworkHandler.Error("Request Failed")
            }
        }
    }
}