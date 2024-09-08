package com.example.data.repo.sources

import com.example.domain.repo.sources.SourcesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideSourcesRepo(
        sourcesRepoImpl: SourcesRepoImpl
    ): SourcesRepo
}