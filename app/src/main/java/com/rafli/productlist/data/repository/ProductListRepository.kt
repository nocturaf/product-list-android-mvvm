package com.rafli.productlist.data.repository

import com.rafli.productlist.data.model.ProductListResponse
import com.rafli.productlist.data.service.ProductListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductListRepository @Inject constructor(private val productListService: ProductListService) {

    fun getProductList(): Flow<ProductListResponse> {
        return flow {
            emit(productListService.getProductList())
        }
    }
}