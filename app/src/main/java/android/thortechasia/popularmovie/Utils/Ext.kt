package android.thortechasia.popularmovie.Utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(context: Context, url: String){
    Glide.with(context)
        .load(url)
        .into(this)
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone(){
    visibility = View.GONE
}