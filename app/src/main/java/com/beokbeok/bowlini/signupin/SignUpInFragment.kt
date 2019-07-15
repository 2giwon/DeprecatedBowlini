package com.beokbeok.bowlini.signupin


import android.os.Bundle
import androidx.lifecycle.Observer
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.beokbeok.bowlini.databinding.FragmentSignUpInBinding

class SignUpInFragment : BaseFragment<FragmentSignUpInBinding>(
    R.layout.fragment_sign_up_in
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        context?.let {
            val vm = SignUpInViewModel(it)
            binding.vm = vm
            binding.lifecycleOwner = this
            vm.activityToStart.observe(
                this,
                Observer { intent ->
                    startActivityForResult(intent, RC_SIGN_IN)
                }
            )
        }
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }
}
