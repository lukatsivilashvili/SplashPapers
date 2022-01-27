package com.luka.splashpapers.screens.home.repository

import com.luka.splashpapers.misc.NetworkHandler
import com.luka.splashpapers.screens.home.models.HomePaginatedModel

interface RecentPhotosRepo {
    suspend fun getRecentPhotos(): NetworkHandler<HomePaginatedModel>
}