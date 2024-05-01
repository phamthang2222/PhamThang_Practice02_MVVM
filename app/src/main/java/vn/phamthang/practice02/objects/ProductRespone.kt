package vn.phamthang.practice02.objects

import com.google.gson.annotations.SerializedName

data class ProductRespone(
    @SerializedName("limit")
    var limit: Int,
    @SerializedName("products")
    var products: List<Product>,
    @SerializedName("skip")
    var skip: Int,
    @SerializedName("total")
    var total: Int
)