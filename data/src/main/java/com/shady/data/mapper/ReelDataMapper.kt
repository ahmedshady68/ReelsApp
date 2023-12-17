package com.shady.data.mapper

import com.shady.data.model.Clip
import com.shady.data.model.ReelsDataModel
import com.shady.domain.entity.ClipDomainModel
import com.shady.domain.entity.ReelsDomainModel

class ReelDataMapper {
    fun apply(dataModel: ReelsDataModel?): ReelsDomainModel {
        val reelsItemDomainEntity = dataModel?.clips?.map { clipItem ->
            mapToReelsItemDomainEntity(clipItem)
        } ?: emptyList()
        return ReelsDomainModel(reelsItemDomainEntity, dataModel?.feedTitle)
    }

    private fun mapToReelsItemDomainEntity(clip: Clip?) =
        ClipDomainModel(
            title = clip?.description ?: "N/A",
            likeCount = clip?.likeCountDisplay ?: "N/A",
            shareCount = clip?.shareCountDisplay ?: "N/A",
            reelUrl = clip?.url ?: "N/A"
        )
}