package com.dbappgame.marvel.domain.model

sealed class BaseResult<T>{
    data class Success <T> (val data: T): BaseResult<T>()
    data class Error <T> (val message: String): BaseResult<T>()
}
