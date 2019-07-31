package com.beokbeok.bowlini.allcar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.beokbeok.bowlini.BR
import com.beokbeok.bowlini.R


class AllCarAdapter : RecyclerView.Adapter<AllCarAdapter.AllCarViewHolder>() {
    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: AllCarViewHolder, position: Int) {
        val vm = AllCarViewModel(/*holder.itemView.context*/)
        holder.bind(vm)

        vm.notifyChange()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCarViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_card_car_detail2,
            parent, false
        )

        return AllCarViewHolder(binding)
    }

    class AllCarViewHolder(
        private val binding :ViewDataBinding
    ) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind(vm: AllCarViewModel) = binding.setVariable(BR.vm, vm)
    }

//    class ExpandableViewHolder(parent: ViewGroup?, resId: Int) : ViewHolder(parent, resId) {
//        private val supportingTextView: TextView = itemView.supporting_text
//        private val expandButton: ImageButton = itemView.expand_button
//
//        init {
//            expandButton.setOnClickListener {
//                if (supportingTextView.visibility == View.VISIBLE) {
//                    expandButton.setImageResource(R.drawable.ic_expand_less_black_36dp)
//                    supportingTextView.visibility = View.GONE
//                } else {
//                    expandButton.setImageResource(R.drawable.ic_expand_more_black_36dp)
//                    supportingTextView.visibility = View.VISIBLE
//                }
//            }
//        }
//
//    }
}