package vn.phamthang.practice02.repositories

import vn.phamthang.practice02.network.api.ApiResponse
import vn.phamthang.practice02.network.api.GenericApiResponse
import vn.phamthang.practice02.network.api.RetrofitClient
import vn.phamthang.practice02.objects.ProductRespone

class ProductRepository : GenericApiResponse() {
    suspend fun getProducts():ApiResponse<ProductRespone>{
        return apiCall { RetrofitClient.getDummyApi.getProducts() }
    }
}