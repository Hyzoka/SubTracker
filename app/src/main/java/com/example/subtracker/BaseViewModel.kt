package com.example.subtracker


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel : ViewModel() {

    protected lateinit var auth: FirebaseAuth

    protected val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    protected val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    protected val _successMessage = MutableStateFlow<String?>(null)
    val successMessage: StateFlow<String?> = _successMessage

    protected fun setLoading() {
        _isLoading.value = true
        _errorMessage.value = null
        _successMessage.value = null
    }

    protected fun setErrorMessage(message: String) {
        _isLoading.value = false
        _errorMessage.value = message
    }

    protected fun setSuccessMessage(message: String) {
        _isLoading.value = false
        _successMessage.value = message
    }

    protected fun logOut(){
        auth.signOut()
    }
}