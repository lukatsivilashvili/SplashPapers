package com.luka.splashpapers.screens.home.repository

import com.luka.splashpapers.misc.NetworkHandler
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem

interface HomePhotosRepo {
    suspend fun getRecentPhotos(): NetworkHandler<List<HomePaginatedModelItem>>
}