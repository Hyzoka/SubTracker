package com.example.ui.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.subtracker.R
import com.example.ui.viewmodel.SubscriptionViewModel

@Composable
fun SignupScreen(
    signupViewModel: SubscriptionViewModel = viewModel(),
    onSignupSuccess: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val isLoading by signupViewModel.isLoading.collectAsState()
    val errorMessage by signupViewModel.error.collectAsState()
    val success by signupViewModel.success.collectAsState()

    if (isLoading) {
        // Afficher un indicateur de chargement
    } else {
        // Afficher le formulaire de création de compte
    }

    if (errorMessage != null) {
        Log.i("ERROR_MESSAGE", "$errorMessage")
    }

    if (success) {
        onSignupSuccess.invoke()
        Log.i("SUCCES_MESSAGE", "DOne")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Center)
            .padding(horizontal = 16.dp)
    ) {
        // Logo and Title
        Image(
            painter = painterResource(R.drawable.baseline_alarm_24),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Create an Account",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Name input field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        // Password input field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Confirm Password input field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Signup button
        Button(
            onClick = {
                Log.i("VAUES_LOGIN","DATA + $email + $password")
                signupViewModel.register(email, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Signup")
        }
    }
}


@Preview
@Composable
fun ComposablePreview() {
    //SignupScreen()
}