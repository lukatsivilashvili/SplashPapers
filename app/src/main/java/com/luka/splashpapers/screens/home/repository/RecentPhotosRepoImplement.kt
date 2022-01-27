package com.luka.splashpapers.screens.home.repository

import com.luka.splashpapers.misc.NetworkHandler
import com.luka.splashpapers.screens.home.models.HomePaginatedModel
import com.luka.splashpapers.screens.home.service.RecentPhotosService
import javax.inject.Inject

class RecentPhotosRepoImplement @Inject constructor(private val recentPhotosService: RecentPhotosService) : RecentPhotosRepo{
    override suspend fun getRecentPhotos(): NetworkHandler<HomePaginatedModel> =
        try {
            val result = recentPhotosService.getRecentPhotos()
            if (result.isSuccessful){
                NetworkHandler.Success(result.body()!!)
            }else{
                NetworkHandler.Error(result.errorBody().toString())
            }
        }catch (e:Exception){
            NetworkHandler.Error("Request Failed")
        }

}