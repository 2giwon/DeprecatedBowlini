package com.beokbeok.bowlini.signupin


import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SignUpInFragment : BaseFragment(R.layout.fragment_sign_up_in) {

    private val googleSignInClient: GoogleSignInClient? by lazy {
        activity?.let {
            GoogleSignIn.getClient(
                it,
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(it.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()
            )
        }
    }
}
