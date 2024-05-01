package vn.phamthang.practice02.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import vn.phamthang.practice02.R
import vn.phamthang.practice02.adapters.ProductAdapter
import vn.phamthang.practice02.base.BaseFragment
import vn.phamthang.practice02.databinding.FragmentProductBinding
import vn.phamthang.practice02.network.api.ApiResponse
import vn.phamthang.practice02.repositories.ProductRepository
import vn.phamthang.practice02.viewmodels.ProductViewModel
import vn.phamthang.practice02.viewmodels.ProductViewModelFactory


class ProductFragment : BaseFragment<FragmentProductBinding>(){

    private lateinit var productViewModel : ProductViewModel
    private lateinit var mProductAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initeViewModel()

        productViewModel.getProduct()
        productViewModel.productData.observe(viewLifecycleOwner){
            when(it){
                is ApiResponse.Loading ->{
                    showDialog()
                }
                is ApiResponse.Success ->{
                    hideDialog()
                    mProductAdapter = ProductAdapter()
                    it.data?.let {
                        mProductAdapter.updateData(it.products)
                        binding.rcvProduct.apply {
                            adapter = mProductAdapter
                            layoutManager = GridLayoutManager(this@ProductFragment.context, 2)
                        }
                    }
                }
                is ApiResponse.Failed ->{
                    hideDialog()
                    Toast.makeText(this@ProductFragment.context, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initeViewModel() {
        val application = activity?.application
        val productRepository = ProductRepository()

        val productViewModelFactory  = ProductViewModelFactory(application!!,productRepository)
        productViewModel = ViewModelProvider(this, factory = productViewModelFactory)[ProductViewModel::class.java]
    }
    companion object{
        @JvmStatic
        fun newInstance() = ProductFragment()
    }

}