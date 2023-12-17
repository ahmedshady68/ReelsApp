package com.shady.reelsapp.presentation.mapper

import com.shady.domain.entity.ClipDomainModel
import com.shady.domain.entity.ReelsDomainModel
import com.shady.reelsapp.presentation.model.ClipPresentationModel
import com.shady.reelsapp.presentation.model.ReelsPresentationModel

class ReelsPresentationMapper {
    fun apply(domainModel: ReelsDomainModel?): ReelsPresentationModel {
        val reelsItemDomainEntity = domainModel?.reels?.map { clipItem ->
            mapToReelsItemDomainEntity(clipItem)
        } ?: emptyList()
        return ReelsPresentationModel(reelsItemDomainEntity, domainModel?.globalTitle)
    }

    private fun mapToReelsItemDomainEntity(clip: ClipDomainModel?) =
        ClipPresentationModel(
            reelTitle = clip?.title ?: "N/A",
            reelLikeCount = clip?.likeCount ?: "N/A",
            reelShareCount = clip?.shareCount ?: "N/A",
            reelUrl = clip?.reelUrl ?: "N/A"
        )
}