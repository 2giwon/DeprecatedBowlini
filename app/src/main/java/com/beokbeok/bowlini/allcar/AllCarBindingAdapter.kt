package com.beokbeok.bowlini.allcar

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:setHasFixedSize")
fun RecyclerView.onSetHasFixedSize(isSet : Boolean) {
    setHasFixedSize(isSet)
}

@BindingAdapter("app:setAdapter")
fun RecyclerView.onSetAdapter(instance: RecyclerView.Adapter<*>) {
    adapter = instance as AllCarAdapter
}