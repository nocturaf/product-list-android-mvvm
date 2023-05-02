package com.rafli.productlist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafli.productlist.data.model.ProductListResponse
import com.rafli.productlist.data.repository.ProductListRepository
import com.rafli.productlist.ui.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val productListRepository: ProductListRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState<ProductListResponse>>(UiState.Loading)

    val uiState: StateFlow<UiState<ProductListResponse>> = _uiState

    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        viewModelScope.launch {
            productListRepository.getProductList()
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}