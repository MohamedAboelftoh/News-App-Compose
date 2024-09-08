package com.example.data.repo.news

import com.example.domain.repo.news.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideNewsRepo(
        newsRepoImpl: NewsRepoImpl
    ): NewsRepo
}