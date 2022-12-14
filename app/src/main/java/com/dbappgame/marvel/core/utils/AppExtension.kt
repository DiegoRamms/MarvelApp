package com.dbappgame.marvel.core.utils

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast


fun <T> T.ifNull(execute: () -> Unit){
    if (this == null) execute.invoke()
}

inline fun <reified T : Parcelable> Bundle.parcelableArrayList(key: String): ArrayList<T>? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableArrayList(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableArrayList(key)
}

fun Context.showLongToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}