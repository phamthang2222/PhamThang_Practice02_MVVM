package vn.phamthang.practice02.network.api.request

import retrofit2.Response
import retrofit2.http.GET
import vn.phamthang.practice02.contants.ConstantApi
import vn.phamthang.practice02.objects.ProductRespone

interface DummyService {
    @GET(ConstantApi.GET_PRODUCT)
    suspend fun getProducts(): Response<ProductRespone>
}