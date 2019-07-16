package com.beokbeok.bowlini.signupin

import androidx.databinding.BindingAdapter
import com.google.android.gms.common.SignInButton

@BindingAdapter("onClick")
fun SignInButton.onClick(method: () -> Unit) {
    setOnClickListener {
        method.invoke()
    }
}