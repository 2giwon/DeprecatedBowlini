package com.beokbeok.bowlini.section

import android.os.Bundle
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.beokbeok.bowlini.databinding.FragmentSectionsBinding

class SectionFragment : BaseFragment<FragmentSectionsBinding>(R.layout.fragment_sections) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let {
            binding.vm = SectionViewModel(it)
        }
    }
}