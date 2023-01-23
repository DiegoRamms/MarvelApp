package com.dbappgame.marvel.core.di.koin

import androidx.viewbinding.BuildConfig
import com.dbappgame.marvel.core.security.AuthInterceptor
import com.dbappgame.marvel.data.datasource.networkdatasource.service.MarvelService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        provideOkHttp()
    }

    single {
        provideRetrofit(get())
    }

    single {
        provideMarvelService(get())
    }
}

fun provideOkHttp(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .addInterceptor( HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun provideMarvelService(retrofit: Retrofit): MarvelService =
    retrofit.create(MarvelService::class.java)
