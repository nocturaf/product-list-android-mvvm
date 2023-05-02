package com.rafli.productlist.data.service

import com.rafli.productlist.data.model.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ProductListService {
    @GET("products")
    suspend fun getProductList(@Query("limit") limit: Int = 10): ProductListResponse
}