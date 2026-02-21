package com.alilopez.kt_demohilt.features.metals.presentation.screens

import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice


data class MetalsUiState(
    val isLoading: Boolean = false,
    val metals: List<MetalPrice> = emptyList(),
    val error: String? = null
)