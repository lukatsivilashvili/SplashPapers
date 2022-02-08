package com.luka.splashpapers.screens.home.models


import com.google.gson.annotations.SerializedName

data class HomePaginatedModelItem(
    @SerializedName("color")
    val color: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("likes")
    val likes: Int?,
    @SerializedName("urls")
    val urls: Urls?
)