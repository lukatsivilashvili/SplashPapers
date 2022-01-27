package com.luka.splashpapers.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.luka.splashpapers.screens.home.models.HomeModelFace
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem

fun ImageView.loadImage(url: String){
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
        .into(this)
}