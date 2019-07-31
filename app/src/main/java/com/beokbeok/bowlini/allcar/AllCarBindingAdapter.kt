package com.beokbeok.bowlini.allcar

import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import com.beokbeok.bowlini.R


@BindingAdapter("app:srcCompat")
fun ImageButton.srcCompat(isTextVisible: Boolean) {
    if (isTextVisible) {
        setImageResource(R.drawable.ic_expand_less_black_36dp)
    } else {
        setImageResource(R.drawable.ic_expand_more_black_36dp)
    }
}
