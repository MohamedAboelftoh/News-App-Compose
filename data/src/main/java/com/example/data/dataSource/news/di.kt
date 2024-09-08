package com.example.data.dataSource.news

import com.example.data.dataSourceContract.news.NewsOfflineDataSource
import com.example.data.dataSourceContract.news.NewsOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideNewsOfflineDataSource(
        newsOfflineDataSourceImpl: NewsOfflineDataSourceImpl
    ):NewsOfflineDataSource
    @Binds
    abstract fun provideNewsOnlineDataSource(
        newsOnlineDataSourceImpl : NewsOnlineDataSourceImpl
    ):NewsOnlineDataSource
}