package vn.phamthang.practice02.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.phamthang.practice02.network.api.ApiResponse
import vn.phamthang.practice02.objects.ProductRespone
import vn.phamthang.practice02.repositories.ProductRepository

class ProductViewModel(application: Application,val productRepository: ProductRepository):AndroidViewModel(application) {
    val productData= MutableLiveData<ApiResponse<ProductRespone>>()

    fun getProduct(){
        productData.value = ApiResponse.Loading()
        viewModelScope.launch {
            val response = productRepository.getProducts()
            productData.value = response
        }
    }

}