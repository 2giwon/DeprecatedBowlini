package com.beokbeok.bowlini.allcar

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.base.BaseViewModel

class AllCarViewModel : BaseViewModel() {

    @Bindable
    var isSupportingTextVisible = MutableLiveData<Boolean>().apply {
        value = false
    }

    fun onExpandText() {
        isSupportingTextVisible.postValue(!(isSupportingTextVisible.value as Boolean))
        notifyChange()
    }


}