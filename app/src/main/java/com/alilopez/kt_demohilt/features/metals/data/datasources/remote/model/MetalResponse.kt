package com.alilopez.kt_demohilt.features.metals.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class MetalResponse(
    val success: Boolean,
    val base: String,
    val date: String? = null,
    @SerializedName("rates")
    val rates: Map<String, Double>
)