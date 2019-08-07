package com.beokbeok.bowlini.allcar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.base.BaseViewModel

class AllCarViewModel: BaseViewModel() {

    private var _adapter =
        MutableLiveData<AllCarAdapter>().apply {
            value = AllCarAdapter()
        }

    val adapter: LiveData<AllCarAdapter>
        get() = _adapter
}