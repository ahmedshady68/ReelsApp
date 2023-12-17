package com.shady.reelsapp.helper

import com.shady.domain.entity.ClipDomainModel
import com.shady.domain.entity.ReelsDomainModel
import com.shady.domain.usecase.GetReelsUseCaseParent
import kotlinx.coroutines.flow.MutableStateFlow

open class FakeGetReelsSuccess : GetReelsUseCaseParent {
    private val responseModelItem: ClipDomainModel = ClipDomainModel("title", "5", "6", "url")
    private val responseModel: ReelsDomainModel? =
        ReelsDomainModel(listOf(responseModelItem), "globalTitle")
    private val stateFlow = MutableStateFlow(responseModel)

    open suspend fun emit(responseModel: ReelsDomainModel?) = stateFlow.emit(responseModel)
    override suspend fun invoke(): ReelsDomainModel? = stateFlow.value
}