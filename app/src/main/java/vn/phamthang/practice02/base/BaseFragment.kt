package vn.phamthang.practice02.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>:Fragment() {

    private var _binding:VB? = null

    protected val binding:VB
        get() = _binding!!

    private lateinit var mProcessDialog: ProgressDialog
    abstract fun inflateBinding(inflater: LayoutInflater,container: ViewGroup?):VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater,container)
        mProcessDialog = ProgressDialog(activity)
        mProcessDialog.setMessage("Loading...")
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showDialog(){
        if(!mProcessDialog.isShowing){
            mProcessDialog.apply {
                show()
                setCanceledOnTouchOutside(false)
                setCancelable(false)
            }
        }
    }
    fun hideDialog(){
        if(mProcessDialog.isShowing){
            mProcessDialog.apply {
                dismiss()
            }
        }
    }

}