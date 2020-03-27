package com.aridwiprayogo.popularmovie.utils

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.aridwiprayogo.popularmovie.BuildConfig
import com.bumptech.glide.Glide

fun ImageView.loadImage(src: String){
    Glide.with(context)
        .load("${BuildConfig.IMAGE_URL}$src")
        .into(this)
}
fun ImageView.loadImage(@DrawableRes src: Int){
    Glide
        .with(context)
        .load("$src")
        .into(this)
}

fun View.gone(){
    this.visibility = View.GONE
}
fun View.visible(){
    this.visibility = View.VISIBLE
}
