package com.dbappgame.marvel.core.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dbappgame.marvel.R


fun ImageView.loadImage(context: Context, url: String, drawable: Drawable?) {
    Glide
        .with(context)
        .load(url)
        .optionalCenterInside()
        .placeholder(R.drawable.ic_launcher_background)
        .into(this);
}


fun View.showOrGone(isVisible: Boolean) {
    alpha = if (isVisible) 0f else 1f

    animate().apply {
        alpha(if (isVisible) 1f else 0f)
        startDelay = if (isVisible) 400 else 1000
        start()
    }
    visibility = if (isVisible) View.VISIBLE else View.GONE
}