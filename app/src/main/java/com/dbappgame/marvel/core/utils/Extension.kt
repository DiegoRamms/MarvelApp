package com.dbappgame.marvel.core.utils


fun <T> T.ifNull(execute: () -> Unit){
    if (this == null) execute.invoke()
}