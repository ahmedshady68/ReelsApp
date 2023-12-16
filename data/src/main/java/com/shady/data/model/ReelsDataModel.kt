package com.shady.data.model

data class ReelsDataModel(
    val clips: List<Clip>,
    val feedTitle: String,
    val feedTitleImageUrl: String,
    val imageTitleAndroid: String,
    val imageTitleIos: String,
    val supportsNavigation: Boolean,
)