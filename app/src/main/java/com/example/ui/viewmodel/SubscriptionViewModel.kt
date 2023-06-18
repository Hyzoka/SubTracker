package com.example.ui.viewmodel

import com.example.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    auth: FirebaseAuth
) : BaseViewModel(auth) {

    fun login(email: String, password: String) {
        _isLoading.value = true
        _error.value = null
        // Appel à Firebase pour la connexion avec email et mot de passe
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _isLoading.value = false
                // Rediriger l'utilisateur vers l'écran principal de l'application
            }
            .addOnFailureListener { exception ->
                _isLoading.value = false
                _error.value = exception.message
            }
    }

    fun register(email: String, password: String) {
        _isLoading.value = true
        _error.value = null

        if (email.isNotEmpty() && password.isNotEmpty())
        // Appel à Firebase pour la création d'un nouveau compte avec email et mot de passe
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _isLoading.value = false
                _success.value = true
                // Rediriger l'utilisateur vers l'écran principal de l'application
            }
            .addOnFailureListener { exception ->
                _isLoading.value = false
                _error.value = exception.message
            }
    }

}
