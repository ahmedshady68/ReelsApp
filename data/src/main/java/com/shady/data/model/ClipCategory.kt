package com.shady.data.model

data class ClipCategory(
    val availableForNavigation: Boolean,
    val displayTitle: String,
    val externalId: String,
    val id: String,
    val name: String,
    val placement: Any,
    val type: String
)