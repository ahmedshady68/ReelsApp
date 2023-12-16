package com.shady.domain.repo

import com.shady.domain.entity.ReelsDomainModel

interface ReelsRepo {
    suspend fun getReelsFromRemote(): ReelsDomainModel?
}