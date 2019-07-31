package com.beokbeok.bowlini.allcar

import androidx.databinding.Bindable
import com.beokbeok.bowlini.base.BaseViewModel

class AllCarViewModel : BaseViewModel() {

    @Bindable
    var isSupportingTextVisible: Boolean = true

    fun onExpandText() {
        isSupportingTextVisible = !isSupportingTextVisible
        notifyChange()
    }


}