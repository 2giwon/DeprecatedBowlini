package com.beokbeok.bowlini.allcar

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseActivity
import kotlinx.android.synthetic.main.activity_allcar_cards.*

class AllCarCardActivity : BaseActivity( R.layout.activity_allcar_cards) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allcar_cards)

        recyclerview_carlist.setHasFixedSize(true)
        recyclerview_carlist.layoutManager = LinearLayoutManager(this)
        recyclerview_carlist.adapter = AllCarAdapter()

    }
}