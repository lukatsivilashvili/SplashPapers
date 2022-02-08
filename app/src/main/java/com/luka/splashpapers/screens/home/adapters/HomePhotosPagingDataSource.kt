package com.luka.splashpapers.screens.home.adapters

import android.util.Log.d
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem
import com.luka.splashpapers.screens.home.repository.HomePhotosRepoImplement
import javax.inject.Inject

class HomePhotosPagingDataSource @Inject constructor(private val recentPhotosRepoImplement: HomePhotosRepoImplement) :
    PagingSource<Int, HomePaginatedModelItem>() {
    override fun getRefreshKey(state: PagingState<Int, HomePaginatedModelItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomePaginatedModelItem> {
        return try {

            val currentPage = params.key ?: 1
            val response = recentPhotosRepoImplement.getRecentPhotos(currentPage)
            val responseData = mutableListOf<HomePaginatedModelItem>()
            val data = response.data ?: emptyList()
            responseData.addAll(data)
            d("myLog", currentPage.toString())

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}