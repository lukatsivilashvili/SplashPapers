package com.luka.splashpapers.utils

import androidx.recyclerview.widget.DiffUtil
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem

object HomePhotosComparator: DiffUtil.ItemCallback<HomePaginatedModelItem>() {
    override fun areItemsTheSame(
        oldItem: HomePaginatedModelItem,
        newItem: HomePaginatedModelItem
    ): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: HomePaginatedModelItem,
        newItem: HomePaginatedModelItem
    ): Boolean {
        return oldItem == newItem
    }
}