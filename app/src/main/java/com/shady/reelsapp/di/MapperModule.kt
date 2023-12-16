package com.shady.reelsapp.di

import com.shady.data.mapper.ReelDataMapper
import com.shady.reelsapp.ui.mapper.ReelsPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    fun provideDateMapper(): ReelDataMapper {
        return ReelDataMapper()
    }

    @Provides
    fun providePresentationMapper(): ReelsPresentationMapper {
        return ReelsPresentationMapper()
    }
}