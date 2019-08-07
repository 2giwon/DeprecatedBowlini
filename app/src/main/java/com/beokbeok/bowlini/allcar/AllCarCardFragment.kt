package com.beokbeok.bowlini.allcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.beokbeok.bowlini.databinding.FragmentAllcarCardsBinding

class AllCarCardFragment :
    BaseFragment<FragmentAllcarCardsBinding>(R.layout.fragment_allcar_cards) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vm = AllCarViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)?.apply {
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        }
    }
}