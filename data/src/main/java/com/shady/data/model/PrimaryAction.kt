package com.shady.data.model

data class PrimaryAction(
    val appStoreId: Any,
    val playStoreBundleId: Any,
    val storeType: String,
    val text: String,
    val type: String,
    val url: String
)