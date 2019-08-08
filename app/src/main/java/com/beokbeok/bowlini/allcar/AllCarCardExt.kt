package com.beokbeok.bowlini.allcar

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:setAdapter")
fun RecyclerView.onSetAdapter(instance: RecyclerView.Adapter<*>?) {
    instance?.let {
        adapter = it as AllCarAdapter
    }
}