package com.beokbeok.bowlini.section

import android.content.Context
import android.content.Intent
import com.beokbeok.bowlini.allcar.AllCarCardActivity
import com.beokbeok.bowlini.base.BaseViewModel
import com.beokbeok.bowlini.signupin.SignUpInActivity

class SectionViewModel(
    private val context: Context
) : BaseViewModel() {

    fun startAllCarActivity() {
        (context as SectionActivity)
            .startActivity(Intent(context, AllCarCardActivity::class.java))
    }

    fun startSettingActivity() {
        (context as SectionActivity)
            .startActivity(Intent(context, SignUpInActivity::class.java))
    }
}