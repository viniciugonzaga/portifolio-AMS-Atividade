package com.example.android_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        _authState.value = if (auth.currentUser == null) {
            AuthState.Unauthenticated
        } else {
            AuthState.Authenticated(auth.currentUser!!)
        }
    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    checkAuthStatus()
                } else {
                    _errorMessage.value = task.exception?.message
                }
            }
    }

    fun signup(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    checkAuthStatus()
                } else {
                    _errorMessage.value = task.exception?.message
                }
            }
    }

    fun logout() {
        auth.signOut()
        checkAuthStatus()
    }

    fun clearError() {
        _errorMessage.value = null
    }
}

sealed class AuthState {
    object Unauthenticated : AuthState()
    data class Authenticated(val user: FirebaseUser) : AuthState()
}