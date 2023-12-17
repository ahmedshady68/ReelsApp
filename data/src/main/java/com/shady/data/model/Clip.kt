package com.shady.data.model

data class Clip(
    val action: Action,
    val audiences: List<Any>,
    val categories: List<String>,
    val clipCategories: List<ClipCategory>,
    val deepLink: String,
    val description: String,
    val duration: Int,
    val externalId: Any,
    val id: String,
    val isLive: Boolean,
    val likeCount: Int,
    val likeCountDisplay: String,
    val links: Links,
    val ogImageUrl: String,
    val playcardUrl: String,
    val primaryAction: PrimaryAction,
    val publishAt: String,
    val removeAt: String,
    val secondaryAction: SecondaryAction,
    val shareCount: Int,
    val shareCountDisplay: String,
    val thumbnailUrl: String,
    val thumbnails: Thumbnails,
    val url: String
)