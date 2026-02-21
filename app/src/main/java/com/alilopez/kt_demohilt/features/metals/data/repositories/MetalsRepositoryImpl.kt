package com.alilopez.kt_demohilt.features.metals.data.repositories

import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.api.MetalsApi
import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.mapper.toDomain
import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice
import com.alilopez.kt_demohilt.features.metals.domain.repositories.MetalsRepository
import javax.inject.Inject

class MetalsRepositoryImpl @Inject constructor(
    private val api: MetalsApi
) : MetalsRepository {

    override suspend fun getMetalPrices(): List<MetalPrice> {
        val response = api.getMetalPrices(
            apiKey = "563d8111cdd74cc499a9fc4a5e399d3e",
            base = "USD",
            currencies = "XAU,XAG"
        )
        return response.toDomain()
    }
}