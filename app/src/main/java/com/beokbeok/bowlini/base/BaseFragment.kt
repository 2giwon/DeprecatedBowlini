package com.beokbeok.bowlini.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB : ViewDataBinding>(
    @LayoutRes
    private val resource: Int
) : Fragment() {

    protected lateinit var binding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            resource,
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    fun showToast(throwable: Throwable) =
        Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
}