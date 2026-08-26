package com.example.android_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.android_app.AuthViewModel
import com.example.android_app.R
import com.example.android_app.ui.theme.Android_appTheme

// --- UI pura (sem ViewModel) para Preview ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onTogglePassword: () -> Unit,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit,
    errorMessage: String?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1A237E), Color(0xFF0D47A1))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_stadium),
                contentDescription = "Estádio",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sociologia do Esporte",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontSize = 24.sp
                )
            )
            Text(
                text = "Faça login para explorar",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.8f))
            )
            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = onEmailChange,
                        label = { Text("E-mail") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = onPasswordChange,
                        label = { Text("Senha") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                        trailingIcon = {
                            IconButton(onClick = onTogglePassword) {
                                Icon(
                                    if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
                    ) {
                        Text("Entrar")
                    }

                    TextButton(
                        onClick = onSignupClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Não tem conta? Cadastre-se", color = Color(0xFF0D47A1))
                    }

                    if (errorMessage != null) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.Red.copy(alpha = 0.1f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = errorMessage,
                                color = Color.Red,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

// --- Função que conecta ao ViewModel (usada no app) ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val errorMessage by authViewModel.errorMessage.observeAsState()

    LaunchedEffect(Unit) {
        authViewModel.clearError()
    }

    LoginContent(
        email = email,
        onEmailChange = { email = it },
        password = password,
        onPasswordChange = { password = it },
        passwordVisible = passwordVisible,
        onTogglePassword = { passwordVisible = !passwordVisible },
        onLoginClick = { authViewModel.login(email, password) },
        onSignupClick = { navController.navigate("signup") },
        errorMessage = errorMessage
    )
}

// --- ⚡ PREVIEW RÁPIDO (clique em "Split" para ver) ---
@Preview(showBackground = true, name = "Login Preview")
@Composable
fun PreviewLogin() {
    Android_appTheme {
        LoginContent(
            email = "teste@email.com",
            onEmailChange = {},
            password = "123456",
            onPasswordChange = {},
            passwordVisible = false,
            onTogglePassword = {},
            onLoginClick = {},
            onSignupClick = {},
            errorMessage = null
        )
    }
}