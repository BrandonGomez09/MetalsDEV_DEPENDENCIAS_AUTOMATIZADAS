package com.alilopez.kt_demohilt.features.metals.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.kt_demohilt.features.metals.domain.usecases.GetMetalPricesUseCase
import com.alilopez.kt_demohilt.features.metals.presentation.screens.MetalsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MetalsViewModel @Inject constructor(
    private val getMetalPricesUseCase: GetMetalPricesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MetalsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadMetalPrices()
    }

    fun loadMetalPrices() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = getMetalPricesUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, metals = list, error = null)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}