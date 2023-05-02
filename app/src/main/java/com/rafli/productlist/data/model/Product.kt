package com.rafli.productlist.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
    @Expose
    @SerializedName("id")
    val productId: Int = 0,
    @Expose
    @SerializedName("title")
    val productName: String = "",
    @Expose
    @SerializedName("thumbnail")
    val productImage: String = "",
    @Expose
    @SerializedName("rating")
    val rating: Float = 0f
)