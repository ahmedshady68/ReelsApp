package com.shady.data.repo

import com.shady.data.mapper.ReelDataMapper
import com.shady.data.remote.ApiService
import com.shady.domain.entity.ReelsDomainModel
import com.shady.domain.repo.ReelsRepo

class ReelsRepoImpl(
    private val apiService: ApiService,
    private val dataMapper: ReelDataMapper,
) :
    ReelsRepo {
    override suspend fun getReelsFromRemote(): ReelsDomainModel =
        dataMapper.apply(apiService.getReels())
}