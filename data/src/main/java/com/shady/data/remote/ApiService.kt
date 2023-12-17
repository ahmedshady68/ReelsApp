package com.shady.data.remote

import com.shady.data.BuildConfig
import com.shady.data.model.ReelsDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("clips")
    suspend fun getReels(@Query("ClientPlatform") city: String = "ANDROID",
                         @Query("ClientVersion") types: String = "9.2.0",
                         @Query("x-storyteller-api-key") key: String = BuildConfig.API_KEY): ReelsDataModel?
}