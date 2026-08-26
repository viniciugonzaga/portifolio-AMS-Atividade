package com.example.android_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_app.pages.HomePage
import com.example.android_app.pages.LoginPage
import com.example.android_app.pages.SignupPage

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
    val authState by authViewModel.authState.observeAsState()

    val startDestination = if (authState is AuthState.Authenticated) "home" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable("login") {
            LoginPage(navController, authViewModel)
        }
        composable("signup") {
            SignupPage(navController, authViewModel)
        }
        composable("home") {
            HomePage(navController, authViewModel)
        }
    }
}