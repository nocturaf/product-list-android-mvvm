package com.rafli.productlist.data.model

import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @SerializedName("products")
    val productList: List<Product>
)