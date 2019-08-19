package com.beokbeok.bowlini.allcar

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.base.BaseViewModel
import com.beokbeok.bowlini.data.Car
import com.beokbeok.bowlini.data.FakeItemsRemoteDataResource

class AllCarViewModel(private val context: Context?) : BaseViewModel() {

    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> get() = _cars

    fun getDataSource() {
        context?.let {
            _cars.value = FakeItemsRemoteDataResource.createCarItems(context)
        }
    }
}