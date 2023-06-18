package com.example.graph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.subtracker.ui.screens.login.screen.ConnectScreen
import com.example.subtracker.ui.screens.login.screen.LoginScreen
import com.example.ui.screens.login.SignupScreen
import com.example.ui.viewmodel.SubscriptionViewModel
import com.google.firebase.auth.FirebaseAuth

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Connect.route
    ) {
        composable(route = AuthScreen.Connect.route) {
            ConnectScreen(
                "",
                onSigninClicked = { navController.navigate(AuthScreen.SignUp.route) },
                onLoginClicked = {
                    navController.navigate(AuthScreen.Login.route)
                })
        }
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onLoginClicked = { email, password -> navController.navigate(Graph.HOME) },
                loginError = null
            )

        }
        composable(route = AuthScreen.SignUp.route) {
            SignupScreen(signupViewModel = SubscriptionViewModel(auth = FirebaseAuth.getInstance()),
                onSignupSuccess = { navController.navigate(Graph.HOME) })
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Connect : AuthScreen(route = "CONNECT")
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}