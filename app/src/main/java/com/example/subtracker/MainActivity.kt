package com.example.subtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.subtracker.graph.RootNavigationGraph
import com.example.subtracker.screens.login.SubscriptionViewModel
import com.example.subtracker.screens.login.screen.ConnectScreen
import com.example.subtracker.screens.login.screen.LoginScreen
import com.example.subtracker.screens.login.screen.SignupScreen
import com.example.subtracker.ui.theme.SubTrackerTheme

class MainActivity : ComponentActivity() {

    private val subscriptionViewModel by viewModels<SubscriptionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RootNavigationGraph(navController = rememberNavController())
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubTrackerTheme {
        ConnectScreen("",{},{})
    }
}