package com.dbappgame.marvel.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dbappgame.marvel.BuildConfig
import com.dbappgame.marvel.data.datasource.localdatasource.database.MarvelDataBase
import com.dbappgame.marvel.data.datasource.localdatasource.database.dao.ComicsDAO
import com.dbappgame.marvel.data.datasource.localdatasource.database.dao.SeriesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MarvelDataBase =
        Room.databaseBuilder(context, MarvelDataBase::class.java, BuildConfig.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideComicsDao(dataBase: MarvelDataBase): ComicsDAO =
        dataBase.getComicsDao()

    @Provides
    @Singleton
    fun provideSeriesDao(dataBase: MarvelDataBase): SeriesDAO =
        dataBase.getSeriesDao()


}