package com.example.subtracker.screens.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.subtracker.R

@Composable
fun ConnectScreen(
    name: String,
    onLoginClicked: () -> Unit,
    onSigninClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_alarm_24),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Bienvenue dans l'application de centralisation d'abonnements",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 32.dp)
        )
        Button(
            onClick = { onLoginClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Se connecter")
        }
        Button(
            onClick = { onSigninClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Créer un compte")
        }
    }
}


@Preview
@Composable
fun ConnectScreenPreview() {
    ConnectScreen("", onLoginClicked = {}, onSigninClicked = {})
}