package com.alilopez.kt_demohilt.features.metals.data.datasources.remote.mapper

import com.alilopez.kt_demohilt.features.metals.data.datasources.remote.model.MetalResponse
import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice

const val USD_TO_MXN = 17.22

fun MetalResponse.toDomain(): List<MetalPrice> {
    val list = mutableListOf<MetalPrice>()

    // Lógica para ORO
    val goldRate = this.rates["XAU"] ?: this.rates["USDXAU"]
    if (goldRate != null) {
        val realGoldPriceUsd = if (goldRate > 0 && goldRate < 1.0) 1.0 / goldRate else goldRate
        list.add(
            MetalPrice(
                name = "Oro (Gold)",
                price = realGoldPriceUsd * USD_TO_MXN,
                currency = "MXN",
                trend = "UP"
            )
        )
    }

    // Lógica para PLATA
    val silverRate = this.rates["XAG"] ?: this.rates["USDXAG"]
    if (silverRate != null) {
        val realSilverPriceUsd = if (silverRate > 0 && silverRate < 1.0) 1.0 / silverRate else silverRate
        list.add(
            MetalPrice(
                name = "Plata (Silver)",
                price = realSilverPriceUsd * USD_TO_MXN,
                currency = "MXN",
                trend = "DOWN"
            )
        )
    }

    return list
}