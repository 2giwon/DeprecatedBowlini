package com.beokbeok.bowlini.allcar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beokbeok.bowlini.R
import kotlinx.android.synthetic.main.item_card_car_detail2.view.*

class AllCarAdapter : RecyclerView.Adapter<AllCarAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ExpandableViewHolder(parent, R.layout.item_card_car_detail2)
    }

    open class ViewHolder(parent: ViewGroup?, resId: Int) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(resId, parent, false))

    class ExpandableViewHolder(parent: ViewGroup?, resId: Int) : ViewHolder(parent, resId) {
        private val supportingTextView: TextView = itemView.supporting_text
        private val expandButton: ImageButton = itemView.expand_button

        init {
            expandButton.setOnClickListener {
                if (supportingTextView.visibility == View.VISIBLE) {
                    expandButton.setImageResource(R.drawable.ic_expand_less_black_36dp)
                    supportingTextView.visibility = View.GONE
                } else {
                    expandButton.setImageResource(R.drawable.ic_expand_more_black_36dp)
                    supportingTextView.visibility = View.VISIBLE
                }
            }
        }

    }
}