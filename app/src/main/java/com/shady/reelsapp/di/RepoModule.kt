package com.shady.reelsapp.di

import com.shady.data.mapper.ReelDataMapper
import com.shady.data.remote.ApiService
import com.shady.data.repo.ReelsRepoImpl
import com.shady.domain.repo.ReelsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiService: ApiService, mapper: ReelDataMapper): ReelsRepo {
        return ReelsRepoImpl(apiService, mapper)
    }
}