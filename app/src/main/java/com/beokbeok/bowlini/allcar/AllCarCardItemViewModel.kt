package com.beokbeok.bowlini.allcar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.base.BaseViewModel

class AllCarCardItemViewModel : BaseViewModel() {

    private val _isSupportingTextVisible =
        MutableLiveData<Boolean>().apply {
            value = false
        }

    val isSupportingTextVisible: LiveData<Boolean>
        get() =_isSupportingTextVisible

    fun onExpandText() {
        _isSupportingTextVisible.value =
            !(_isSupportingTextVisible.value as Boolean)
        notifyChange()
    }


}