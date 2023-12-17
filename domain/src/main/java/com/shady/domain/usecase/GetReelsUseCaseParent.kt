package com.shady.domain.usecase

import com.shady.domain.entity.ReelsDomainModel

interface GetReelsUseCaseParent {
    suspend operator fun invoke(): ReelsDomainModel?
}