package vn.phamthang.practice02.adapters

import com.bumptech.glide.Glide
import vn.phamthang.practice02.R
import vn.phamthang.practice02.base.BaseRecyclerViewAdapter
import vn.phamthang.practice02.databinding.LayoutItemProductBinding
import vn.phamthang.practice02.objects.Product

class ProductAdapter : BaseRecyclerViewAdapter<Product, LayoutItemProductBinding>(){
    override fun getLayout(): Int = R.layout.layout_item_product

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<LayoutItemProductBinding>,
        position: Int
    ) {
        holder.binding.product = mListData[position]
        Glide.with(mContext)
            .load(mListData[position].images)
            .into(holder.binding.imgProduct)
    }
}