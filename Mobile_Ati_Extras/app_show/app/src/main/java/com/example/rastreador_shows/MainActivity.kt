package com.example.rastreador_shows

import android.os.Bundle
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rastreador_shows.Data.AppDatabase
import com.example.rastreador_shows.Data.ShowDao
import com.example.rastreador_shows.Data.ShowEntity
import com.example.rastreador_shows.ui.theme.Rastreador_ShowsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Garante a instância única do banco fora do ciclo de recomposição do Compose
        val database = AppDatabase.getDatabase(applicationContext)
        val showDao = database.showDao()

        setContent {
            Rastreador_ShowsTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController, showDao = showDao)
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, showDao: ShowDao) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("cadastro") { CadastroScreen(navController) }

        composable(
            route = "dashboard/{nome}/{email}",
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: "Usuário"
            val email = backStackEntry.arguments?.getString("email") ?: "usuario@email.com"
            DashboardScreen(navController, showDao, nome, email)
        }

        composable(
            route = "perfil/{nome}/{email}",
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: "Usuário"
            val email = backStackEntry.arguments?.getString("email") ?: "usuario@email.com"
            PerfilScreen(navController, nome, email)
        }
    }
}

// 1. SPLASH SCREEN
@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = startAnimation,
            enter = fadeIn(animationSpec = tween(800)) + expandVertically(),
            exit = fadeOut(animationSpec = tween(400))
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.icon_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(130.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

// 2. TELA DE LOGIN
@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth().border(1.dp, Color(0xFF333333), RoundedCornerShape(24.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp).fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(90.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "FEST TRACKER", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val emailLimpo = email.ifBlank { "usuario@email.com" }.trim()
                        val nomeSimulado = emailLimpo.substringBefore("@").replaceFirstChar { it.uppercase() }
                        val encodedNome = Uri.encode(nomeSimulado)
                        val encodedEmail = Uri.encode(emailLimpo)
                        navController.navigate("dashboard/$encodedNome/$encodedEmail") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Entrar", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { navController.navigate("cadastro") }) {
                    Text("Criar uma nova conta", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}

// 3. TELA DE CADASTRO
@Composable
fun CadastroScreen(navController: NavHostController) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(24.dp).fillMaxWidth()) {
                Text(text = "Cadastre-se", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome Completo") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), singleLine = true)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("E-mail") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), singleLine = true)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(value = senha, onValueChange = { senha = it }, label = { Text("Senha") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), singleLine = true)
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val nomeEnvio = nome.ifBlank { "Novo Usuário" }.trim()
                        val emailEnvio = email.ifBlank { "cadastro@email.com" }.trim()
                        val encodedNome = Uri.encode(nomeEnvio)
                        val encodedEmail = Uri.encode(emailEnvio)
                        navController.navigate("dashboard/$encodedNome/$encodedEmail") {
                            popUpTo("cadastro") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Finalizar Cadastro")
                }
            }
        }
    }
}

// 4. TELA DASHBOARD
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController, showDao: ShowDao, nomeUsuario: String, emailUsuario: String) {
    val coroutineScope = rememberCoroutineScope()
    val showsList by showDao.getShowsByUser(emailUsuario).collectAsState(initial = emptyList())

    var searchQuery by remember { mutableStateOf("") }
    var precoFiltroSelecionado by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
    var showSuccessAnimation by remember { mutableStateOf(false) }

    var showIdToEdit by remember { mutableStateOf<Int?>(null) }
    var artistaInput by remember { mutableStateOf("") }
    var dataInput by remember { mutableStateOf("") }
    var localInput by remember { mutableStateOf("") }
    var valorInput by remember { mutableStateOf("") }

    val showsFiltrados = remember(showsList, searchQuery, precoFiltroSelecionado) {
        showsList.filter { show ->
            val atendePesquisa = show.artista.contains(searchQuery, ignoreCase = true)
            val atendePreco = when (precoFiltroSelecionado) {
                1 -> show.valorIngresso <= 400.0
                2 -> show.valorIngresso > 400.0
                else -> true
            }
            atendePesquisa && atendePreco
        }
    }

    val custoTotalIngressos = remember(showsList) { showsList.sumOf { it.valorIngresso } }
    val totalShowsAgendados = showsList.size

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.icon_logo), contentDescription = "Logo", modifier = Modifier.size(32.dp).clip(CircleShape))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "FEST TRACKER", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Shows") },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = false,
                    onClick = {
                        val encNome = Uri.encode(nomeUsuario)
                        val encEmail = Uri.encode(emailUsuario)
                        navController.navigate("perfil/$encNome/$encEmail") {
                            launchSingleTop = true
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showIdToEdit = null
                    artistaInput = ""; dataInput = ""; localInput = ""; valorInput = ""
                    showDialog = true
                },
                containerColor = com.example.rastreador_shows.ui.theme.BluePrimary,
                contentColor = Color.White
            ) { Icon(Icons.Default.Add, contentDescription = "Adicionar Show") }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Pesquisar artista...", color = Color.Gray) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.LightGray) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = MaterialTheme.colorScheme.primary)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Card(modifier = Modifier.weight(1f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Seu Investimento", style = MaterialTheme.typography.labelMedium, color = Color.LightGray)
                            Text("R$ ${String.format("%.2f", custoTotalIngressos)}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = com.example.rastreador_shows.ui.theme.GreenAccent)
                        }
                    }
                    Card(modifier = Modifier.weight(1f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Seus Shows", style = MaterialTheme.typography.labelMedium, color = Color.LightGray)
                            Text("$totalShowsAgendados salvos", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = com.example.rastreador_shows.ui.theme.BluePrimary)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(selected = precoFiltroSelecionado == 0, onClick = { precoFiltroSelecionado = 0 }, label = { Text("Todos") })
                    FilterChip(selected = precoFiltroSelecionado == 1, onClick = { precoFiltroSelecionado = 1 }, label = { Text("Até R$ 400") })
                    FilterChip(selected = precoFiltroSelecionado == 2, onClick = { precoFiltroSelecionado = 2 }, label = { Text("VIP (>400)") })
                }

                Spacer(modifier = Modifier.height(12.dp))

                if (showsFiltrados.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize().weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Nenhum show seu encontrado.", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    }
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxSize().weight(1f)) {
                        items(showsFiltrados, key = { it.id }) { show ->
                            ShowCard(
                                show = show,
                                onEditClick = {
                                    showIdToEdit = show.id
                                    artistaInput = show.artista
                                    dataInput = show.data
                                    localInput = show.local
                                    valorInput = show.valorIngresso.toString()
                                    showDialog = true
                                },
                                onDeleteClick = { coroutineScope.launch { showDao.deleteShow(show) } }
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(visible = showSuccessAnimation, enter = fadeIn() + scaleIn(), exit = fadeOut() + scaleOut(), modifier = Modifier.align(Alignment.Center)) {
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), modifier = Modifier.size(170.dp), shape = RoundedCornerShape(24.dp)) {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = com.example.rastreador_shows.ui.theme.GreenAccent, modifier = Modifier.size(56.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Salvo!", style = MaterialTheme.typography.titleMedium, color = Color.White)
                    }
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(if (showIdToEdit == null) "Cadastrar Show" else "Editar Show") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(value = artistaInput, onValueChange = { artistaInput = it }, label = { Text("Artista/Banda") }, singleLine = true)
                    OutlinedTextField(value = dataInput, onValueChange = { dataInput = it }, label = { Text("Data") }, singleLine = true)
                    OutlinedTextField(value = localInput, onValueChange = { localInput = it }, label = { Text("Local") }, singleLine = true)
                    OutlinedTextField(value = valorInput, onValueChange = { valorInput = it }, label = { Text("Preço") }, singleLine = true)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val novoShow = ShowEntity(
                            id = showIdToEdit ?: 0,
                            artista = artistaInput,
                            data = dataInput,
                            local = localInput,
                            valorIngresso = valorInput.toDoubleOrNull() ?: 0.0,
                            userEmail = emailUsuario
                        )
                        coroutineScope.launch {
                            if (showIdToEdit == null) showDao.insertShow(novoShow) else showDao.updateShow(novoShow)
                            showDialog = false
                            showSuccessAnimation = true
                            delay(1000)
                            showSuccessAnimation = false
                        }
                    }
                ) { Text("Salvar") }
            },
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } }
        )
    }
}

// 5. TELA DE PERFIL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(navController: NavHostController, nomeUsuario: String, emailUsuario: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("MEU PERFIL", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Shows") },
                    selected = false,
                    onClick = {
                        val encNome = Uri.encode(nomeUsuario)
                        val encEmail = Uri.encode(emailUsuario)
                        navController.navigate("dashboard/$encNome/$encEmail") {
                            launchSingleTop = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = true,
                    onClick = {}
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier.size(100.dp).background(com.example.rastreador_shows.ui.theme.BluePrimary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                val inicial = nomeUsuario.trim().firstOrNull()?.toString()?.uppercase() ?: "U"
                Text(inicial, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = nomeUsuario, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = emailUsuario, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Status da Conta", color = Color.LightGray)
                        Text("Ativa", color = com.example.rastreador_shows.ui.theme.GreenAccent, fontWeight = FontWeight.Bold)
                    }
                    HorizontalDivider(color = Color(0xFF333333))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Espaço de Armazenamento", color = Color.LightGray)
                        Text("Exclusivo Local", color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = com.example.rastreador_shows.ui.theme.RedAccent),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sair da Conta", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ShowCard(show: ShowEntity, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    val bordasColoridas = listOf(
        com.example.rastreador_shows.ui.theme.BluePrimary,
        com.example.rastreador_shows.ui.theme.GreenAccent,
        com.example.rastreador_shows.ui.theme.YellowAccent,
        com.example.rastreador_shows.ui.theme.RedAccent
    )
    val corDestaque = bordasColoridas[show.id % bordasColoridas.size]

    Card(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).clickable { onEditClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            Box(modifier = Modifier.fillMaxHeight().width(6.dp).background(corDestaque))

            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = show.artista, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color.White)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "R$ ${String.format("%.2f", show.valorIngresso)}", style = MaterialTheme.typography.labelLarge, color = com.example.rastreador_shows.ui.theme.GreenAccent)
                        Spacer(modifier = Modifier.width(12.dp))
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Deletar",
                            tint = com.example.rastreador_shows.ui.theme.RedAccent,
                            modifier = Modifier.size(20.dp).clickable { onDeleteClick() }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null, tint = com.example.rastreador_shows.ui.theme.BluePrimary, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = show.data, style = MaterialTheme.typography.bodySmall, color = Color.LightGray)
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = com.example.rastreador_shows.ui.theme.RedAccent, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = show.local, style = MaterialTheme.typography.bodySmall, color = Color.LightGray)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    Rastreador_ShowsTheme {
        val dummyController = rememberNavController()
        DashboardScreen(navController = dummyController, showDao = AppDatabase.getDatabase(LocalContext.current).showDao(), nomeUsuario = "Vinícius", emailUsuario = "vinicius@email.com")
    }
}