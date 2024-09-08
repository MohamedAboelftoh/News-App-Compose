package com.example.data.common

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    @Singleton
    abstract fun provideNetworkHandler(
        networkHandlerImpl: NetworkHandlerImpl
    ) : NetWorkHandler
}