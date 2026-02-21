package com.alilopez.kt_demohilt.features.metals.data.datasources.remote

import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.model.MetalResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MetalsApi {
    @GET("latest")
    suspend fun getMetalPrices(
        @Query("api_key") apiKey: String,
        @Query("base") base: String,
        @Query("currencies") currencies: String
    ): MetalResponse
}