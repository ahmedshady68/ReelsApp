package com.shady.reelsapp.di

import com.shady.domain.repo.ReelsRepo
import com.shady.domain.usecase.GetReelsUseCase
import com.shady.domain.usecase.GetReelsUseCaseParent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(repo: ReelsRepo): GetReelsUseCaseParent {
        return GetReelsUseCase(repo)
    }
}