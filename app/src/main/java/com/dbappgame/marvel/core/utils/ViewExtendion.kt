package com.dbappgame.marvel.core.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dbappgame.marvel.R


fun ImageView.loadImage(context: Context,url: String, drawable: Drawable?){
    Glide
        .with(context)
        .load(url)
        .optionalCenterInside()
        .placeholder(R.drawable.ic_launcher_background)
        .into(this);
}