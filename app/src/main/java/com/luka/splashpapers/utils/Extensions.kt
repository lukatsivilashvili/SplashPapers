package com.luka.splashpapers.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, colors:String){
    Glide.with(this.context)
        .load(url)
        .placeholder(ColorDrawable(Color.parseColor(colors)))
        .into(this)
}