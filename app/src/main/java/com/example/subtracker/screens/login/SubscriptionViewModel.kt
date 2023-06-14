package com.example.subtracker.screens.login

import com.example.subtracker.BaseViewModel

class SubscriptionViewModel : BaseViewModel() {

    fun login(email: String, password: String) {
        _isLoading.value = true
        _errorMessage.value = null
        // Appel à Firebase pour la connexion avec email et mot de passe
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _isLoading.value = false
                // Rediriger l'utilisateur vers l'écran principal de l'application
            }
            .addOnFailureListener { exception ->
                _isLoading.value = false
                _errorMessage.value = exception.message
            }
    }

    fun register(email: String, password: String) {
        _isLoading.value = true
        _errorMessage.value = null
        // Appel à Firebase pour la création d'un nouveau compte avec email et mot de passe
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _isLoading.value = false
                // Rediriger l'utilisateur vers l'écran principal de l'application
            }
            .addOnFailureListener { exception ->
                _isLoading.value = false
                _errorMessage.value = exception.message
            }
    }

}
