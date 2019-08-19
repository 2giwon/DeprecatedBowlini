package com.beokbeok.bowlini.allcar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.beokbeok.bowlini.databinding.FragmentAllcarCardsBinding

class AllCarCardFragment :
    BaseFragment<FragmentAllcarCardsBinding>(R.layout.fragment_allcar_cards) {

    private lateinit var viewModel: AllCarViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = AllCarViewModel(context)
        binding.vm = viewModel
        initFragment()
        registerObserver()
    }

    private fun initFragment() {
        with(binding.recyclerviewCarlist) {
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
            setHasFixedSize(true)
            adapter = AllCarAdapter(viewModel)
        }
    }

    private fun registerObserver() {
        viewModel.cars.observe(
            this,
            Observer {

            }
        )
    }
}