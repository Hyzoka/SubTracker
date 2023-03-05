package com.example.subtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.subtracker.login.SubscriptionViewModel
import com.example.subtracker.login.screen.ConnectScreen
import com.example.subtracker.login.screen.LoginScreen
import com.example.subtracker.login.screen.SignupScreen
import com.example.subtracker.ui.theme.SubTrackerTheme

class MainActivity : ComponentActivity() {

    private val subscriptionViewModel by viewModels<SubscriptionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLoading = subscriptionViewModel.isLoading.collectAsState()

            ConnectScreen()
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(onLoginClicked = {email, password ->  },loginError = null)
            //call LoginScreen composable function here
        }

        composable(route = "signIn") {
            SignupScreen()
            //call HomeScreen composable function here
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubTrackerTheme {
        ConnectScreen()
    }
}