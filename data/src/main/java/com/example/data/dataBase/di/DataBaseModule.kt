package com.example.data.dataBase.di

import android.content.Context
import androidx.room.Room
import com.example.data.dataBase.NewsDataBase
import com.example.data.dataBase.dao.NewsDao
import com.example.data.dataBase.dao.SourcesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDataBase(
        @ApplicationContext context: Context
    ): NewsDataBase {
        return Room.databaseBuilder(
            context.applicationContext ,
            NewsDataBase::class.java,
            "News Database")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideNewsDao(
        newsDataBase: NewsDataBase
    ): NewsDao {
        return newsDataBase.newsDao()
    }
    @Singleton
    @Provides
    fun provideSourcesDao(
        newsDataBase: NewsDataBase
    ): SourcesDao {
        return newsDataBase.sourcesDao()
    }
}