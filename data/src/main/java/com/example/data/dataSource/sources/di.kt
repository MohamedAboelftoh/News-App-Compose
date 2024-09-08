package com.example.data.dataSource.sources

import com.example.data.dataSourceContract.sources.SourcesOfflineDataSource
import com.example.data.dataSourceContract.sources.SourcesOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideSourcesOfflineDataSource(
        sourcesOfflineDataSourceImpl : SourcesOfflineDataSourceImpl
    ) : SourcesOfflineDataSource

    @Binds
    abstract fun provideSourcesOnlineDataSource(
        sourcesOnlineDataSourceImpl : SourcesOnlineDataSourceImpl
    ) : SourcesOnlineDataSource
}