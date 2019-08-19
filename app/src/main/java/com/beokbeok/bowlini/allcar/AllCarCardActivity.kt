package com.beokbeok.bowlini.allcar

import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseActivity
import com.beokbeok.bowlini.databinding.ActivityAllcarCardsBinding

class AllCarCardActivity :
    BaseActivity<ActivityAllcarCardsBinding>(R.layout.activity_allcar_cards) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerviewCarlist.setHasFixedSize(true)
        binding.recyclerviewCarlist.adapter = AllCarAdapter()
    }
}

