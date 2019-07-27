package com.beokbeok.bowlini.signupin


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.beokbeok.bowlini.databinding.FragmentSignUpInBinding

class SignUpInFragment : BaseFragment<FragmentSignUpInBinding>(
    R.layout.fragment_sign_up_in
) {
    private lateinit var vm: SignUpInViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBinding()
        registerObserver()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == RC_SIGN_IN) {
            vm.firebaseAuthWithGoogle(data)
        }
    }

    private fun initBinding() {
        context?.let {
            vm = SignUpInViewModel(it)
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

    private fun registerObserver() {
        binding.vm?.errMsg?.observe(
            this,
            Observer {
                showToast(it)
            }
        )
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }
}
