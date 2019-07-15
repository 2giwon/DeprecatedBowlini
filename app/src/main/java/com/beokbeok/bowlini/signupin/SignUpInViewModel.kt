package com.beokbeok.bowlini.signupin

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class SignUpInViewModel(
    private val context: Context
) : BaseViewModel() {
    private val _googleSignInClient: GoogleSignInClient? by lazy {
        GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )
    }
    private val _auth = FirebaseAuth.getInstance()
    val auth
        get() = _auth
    val activityToStart = MutableLiveData<Intent>()

    fun signin() {
        _googleSignInClient?.let {
            activityToStart.postValue(it.signInIntent)
        }
    }
}