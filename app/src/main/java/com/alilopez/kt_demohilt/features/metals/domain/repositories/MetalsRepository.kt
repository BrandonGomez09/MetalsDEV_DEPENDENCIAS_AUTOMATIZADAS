package com.alilopez.kt_demohilt.features.metals.domain.repositories

import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice

interface MetalsRepository {
    suspend fun getMetalPrices(): List<MetalPrice>
}