package vn.phamthang.practice02.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.phamthang.practice02.repositories.ProductRepository

class ProductViewModelFactory(val application: Application,val productRepository: ProductRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(application, productRepository) as T
    }
}