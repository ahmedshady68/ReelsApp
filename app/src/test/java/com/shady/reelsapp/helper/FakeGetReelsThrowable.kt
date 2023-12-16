package com.shady.reelsapp.helper

import com.shady.domain.entity.ReelsDomainModel
import com.shady.domain.usecase.GetReelsUseCaseParent

open class FakeGetReelsThrowable : GetReelsUseCaseParent {
    private var throwable: Throwable = Throwable()
    override suspend fun invoke(): ReelsDomainModel? = throw throwable

    fun setThrowable(throwable: Throwable) {
        this.throwable = throwable
    }
}