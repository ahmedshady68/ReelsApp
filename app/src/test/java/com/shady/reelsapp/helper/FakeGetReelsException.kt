package com.shady.reelsapp.helper

import com.shady.domain.entity.ReelsDomainModel
import com.shady.domain.usecase.GetReelsUseCaseParent

open class FakeGetReelsException : GetReelsUseCaseParent {
    private var exception: Exception = Exception()
    override suspend fun invoke(): ReelsDomainModel? = throw exception

    fun setException(e: Exception) {
        exception = e
    }
}