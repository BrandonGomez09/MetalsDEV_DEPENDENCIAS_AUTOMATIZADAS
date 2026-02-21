package com.alilopez.kt_demohilt.features.metals.domain.usecases

import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice
import com.alilopez.kt_demohilt.features.metals.domain.repositories.MetalsRepository
import javax.inject.Inject

class GetMetalPricesUseCase @Inject constructor(
    private val repository: MetalsRepository
) {
    suspend operator fun invoke(): Result<List<MetalPrice>> {
        return try {
            val prices = repository.getMetalPrices()
            if (prices.isNotEmpty()) {
            Result.success(prices)
            } else {
                Result.failure(Exception("No se encontraron precios de metales."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}