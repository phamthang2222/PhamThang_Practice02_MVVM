package vn.phamthang.practice02.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vn.phamthang.practice02.R
import vn.phamthang.practice02.base.BaseActivity
import vn.phamthang.practice02.databinding.ActivityMainBinding
import vn.phamthang.practice02.ui.fragments.ProductFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(ProductFragment.newInstance(),"","")
    }
}