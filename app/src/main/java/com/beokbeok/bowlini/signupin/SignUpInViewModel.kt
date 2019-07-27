package com.beokbeok.bowlini.signupin

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.beokbeok.bowlini.R
import com.beokbeok.bowlini.base.BaseViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

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
    val activityToStart = MutableLiveData<Intent>()
    val errMsg = MutableLiveData<Throwable>()

    fun signIn() {
        _googleSignInClient?.let {
            activityToStart.postValue(it.signInIntent)
        }
    }

    fun firebaseAuthWithGoogle(intent: Intent?) {
        val account = try {
            GoogleSignIn.getSignedInAccountFromIntent(intent)
                .getResult(ApiException::class.java)
                ?.idToken
        } catch (e: ApiException) {
            errMsg.value = e
            return
        }
        _auth.signInWithCredential(
            GoogleAuthProvider.getCredential(
                account,
                null
            )
        ).addOnCompleteListener {
            // TODO UI 업데이트
            if (it.isSuccessful) {
                Log.d("kkk", _auth.currentUser.toString())
            } else {
                Log.d("kkk", "login fail")
            }
        }

    }
}