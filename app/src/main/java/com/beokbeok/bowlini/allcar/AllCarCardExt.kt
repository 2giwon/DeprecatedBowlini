package com.beokbeok.bowlini.allcar

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beokbeok.bowlini.base.BaseRecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("app:replaceItems")
fun RecyclerView.replaceItems(items: List<Any>?) {
    (this.adapter as? BaseRecyclerView.Adapter<Any, *>)?.run {
        replaceItems(items)
        notifyDataSetChanged()
    }
}

