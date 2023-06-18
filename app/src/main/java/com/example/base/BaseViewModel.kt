package com.example.base


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel @ViewModelInject constructor(
    protected val auth: FirebaseAuth
) : ViewModel() {

    protected val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    protected val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    protected val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    protected fun setLoading() {
        _isLoading.value = true
        _error.value = null
        _success.value = false
    }

    protected fun setErrorMessage(message: String) {
        _isLoading.value = false
        _error.value = message
    }

    protected fun setSuccess() {
        _isLoading.value = false
        _success.value = true
    }

    protected fun logOut(){
        auth.signOut()
    }
}