package com.beokbeok.bowlini.allcar

import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseRecyclerView
import com.beokbeok.bowlini.data.Car
import com.beokbeok.bowlini.databinding.ItemCardCarDetail2Binding

class AllCarAdapter(
    viewModel: AllCarViewModel
) : BaseRecyclerView.Adapter<Car, ItemCardCarDetail2Binding>(
    layoutRes,
    bindingVariableId
) {

    init {
        viewModel.getDataSource()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerView.ViewHolder<ItemCardCarDetail2Binding> = ViewHolder(parent)

    inner class ViewHolder(
        parent: ViewGroup
    ) : BaseRecyclerView.ViewHolder<ItemCardCarDetail2Binding>(
        layoutRes,
        parent,
        bindingVariableId
    ) {
        init {
            binding.vm = AllCarCardItemViewModel()
        }
    }

    companion object {
        private const val layoutRes = R.layout.item_card_car_detail2
        private const val bindingVariableId = BR.car
    }
}