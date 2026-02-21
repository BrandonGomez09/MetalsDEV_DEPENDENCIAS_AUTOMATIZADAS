package com.alilopez.kt_demohilt.features.metals.data.datasources.remote.mapper

import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.models.MetalResponse
import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice

const val USD_TO_MXN = 17.22

fun MetalResponse.toDomain(): List<MetalPrice> {
    val list = mutableListOf<MetalPrice>()

    val goldRate = this.rates["XAU"] ?: this.rates["USDXAU"]
    if (goldRate != null) {
        val realGoldPriceUsd = if (goldRate > 0 && goldRate < 1.0) 1.0 / goldRate else goldRate
        list.add(MetalPrice("Oro (Gold)", realGoldPriceUsd * USD_TO_MXN, "MXN", "UP"))
    }

    val silverRate = this.rates["XAG"] ?: this.rates["USDXAG"]
    if (silverRate != null) {
        val realSilverPriceUsd = if (silverRate > 0 && silverRate < 1.0) 1.0 / silverRate else silverRate
        list.add(MetalPrice("Plata (Silver)", realSilverPriceUsd * USD_TO_MXN, "MXN", "DOWN"))
    }

    return list
}