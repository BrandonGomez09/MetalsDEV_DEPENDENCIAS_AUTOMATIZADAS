package com.alilopez.kt_demohilt.features.metals.domain.entities


data class MetalPrice(
    val name: String,
    val price: Double,
    val currency: String,
    val trend: String
)