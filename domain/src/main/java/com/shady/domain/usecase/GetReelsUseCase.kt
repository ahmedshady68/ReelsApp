package com.shady.domain.usecase

import com.shady.domain.repo.ReelsRepo

class GetReelsUseCase(private val repo: ReelsRepo) {
    suspend operator fun invoke() = repo.getReelsFromRemote()
}