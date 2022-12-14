package com.dbappgame.marvel.core.di

import com.dbappgame.marvel.core.security.AuthInterceptor
import com.dbappgame.marvel.BuildConfig
import com.dbappgame.marvel.data.datasource.networkdatasource.service.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor( HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMarvelService(retrofit: Retrofit): MarvelService =
        retrofit.create(MarvelService::class.java)


}
