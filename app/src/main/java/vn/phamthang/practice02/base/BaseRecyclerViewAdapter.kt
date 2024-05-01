package vn.phamthang.practice02.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any, VDB : ViewDataBinding>
    : RecyclerView.Adapter<BaseRecyclerViewAdapter.Companion.BaseViewHolder<VDB>>() {

    companion object {
        class BaseViewHolder<VDB : ViewDataBinding>(var binding: VDB) :
            RecyclerView.ViewHolder(binding.root)
    }

    var mListData = mutableListOf<T>()

    fun updateData(data: List<T>) {
        this.mListData = data as MutableList<T>
        notifyDataSetChanged()
    }

    lateinit var mContext: Context

    var listener:((view: View, item:T,position:Int)->Unit)?=null

    abstract fun getLayout():Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> {
        this.mContext = parent.context
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),getLayout(),parent,false))
    }

    override fun getItemCount(): Int {
       if(mListData.isEmpty()){
           return 0
       }
        return mListData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        TODO("Not yet implemented")
    }


}