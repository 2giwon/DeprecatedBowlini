package com.beokbeok.bowlini.allcar

import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.base.BaseViewModel

class AllCarViewModel : BaseViewModel() {

    val isSupportingTextVisible = MutableLiveData<Boolean>().apply {
        value = false
    }

    fun onExpandText() {
        isSupportingTextVisible.postValue(!(isSupportingTextVisible.value as Boolean))
        notifyChange()
    }


}