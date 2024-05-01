package vn.phamthang.practice02.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter {
    @BindingAdapter("urlImage")
    fun glideImage(imageView: ImageView,url:String){
        Glide.with(imageView).load(url).into(imageView)
    }
}