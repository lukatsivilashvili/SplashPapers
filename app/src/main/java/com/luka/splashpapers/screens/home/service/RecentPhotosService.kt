package com.luka.splashpapers.screens.home.service

import com.luka.splashpapers.BuildConfig.API_KEY
import com.luka.splashpapers.screens.home.models.HomePaginatedModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentPhotosService {

    @GET("photos")
    suspend fun getRecentPhotos(
        @Query("page") page: Int = 1,
        @Query("order_by") order: String = "popular",
        @Query("client_id") clientId: String = API_KEY
    ): Response<HomePaginatedModel>

}