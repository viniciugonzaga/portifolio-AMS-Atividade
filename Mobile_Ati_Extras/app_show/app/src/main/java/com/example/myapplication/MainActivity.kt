package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RastreadorShowsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RastreadorShowsScreen(modifier: Modifier = Modifier) {
    var pesquisa by remember { mutableStateOf("") }
    var listaShows by remember { mutableStateOf(ShowRepository.getShowsFicticios()) }
    var abaSelecionada by remember { mutableIntStateOf(0) } // 0 = Todos, 1 = Favoritos

    // NOVA FUNCIONALIDADE: Estado da cidade selecionada ("Todas" por padrão)
    var cidadeSelecionada by remember { mutableStateOf("Todas") }
    val cidadesDisponiveis = listOf("Todas", "São Paulo", "Rio de Janeiro", "Belo Horizonte", "Florianópolis", "Salvador")

    val showDestaque = ShowRepository.getShowDestaque()
    val context = LocalContext.current

    // Filtragem combinada: Pesquisa + Aba Favoritos + Filtro de Cidade
    val showsFiltrados = listaShows.filter { show ->
        val matchesPesquisa = show.artista.contains(pesquisa, ignoreCase = true) ||
                show.cidade.contains(pesquisa, ignoreCase = true)
        val matchesAba = if (abaSelecionada == 1) show.isFavorito else true
        val matchesCidade = if (cidadeSelecionada != "Todas") show.cidade.equals(cidadeSelecionada, ignoreCase = true) else true

        matchesPesquisa && matchesAba && matchesCidade
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F9))
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.horizontalGradient(listOf(Color(0xFF6200EE), Color(0xFF3700B3))))
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = "⚡ ShowTracker",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Banner de Destaque
            if (abaSelecionada == 0 && pesquisa.isEmpty() && cidadeSelecionada == "Todas") {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("DESTAQUE DA SEMANA", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF121212))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD700))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("EM DESTAQUE", color = Color(0xFFFFD700), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                            Text(showDestaque.artista, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Black)
                            Text("📍 ${showDestaque.local} - ${showDestaque.cidade}", color = Color.LightGray, fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(showDestaque.urlCompra))
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text("Garantir Ingresso", color = Color.White)
                            }
                        }
                    }
                }
            }

            // 2. Barra de Pesquisa, Filtros de Cidade e Abas
            item {
                OutlinedTextField(
                    value = pesquisa,
                    onValueChange = { pesquisa = it },
                    label = { Text("Buscar artista ou cidade...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // NOVA FUNCIONALIDADE: Carrossel horizontal de Cidades (Filter Chips)
                Text("FILTRAR POR CIDADE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(cidadesDisponiveis) { cidade ->
                        val selecionada = cidade == cidadeSelecionada
                        FilterChip(
                            selected = selecionada,
                            onClick = { cidadeSelecionada = cidade },
                            label = { Text(cidade) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF6200EE),
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Abas
                TabRow(
                    selectedTabIndex = abaSelecionada,
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF6200EE)
                ) {
                    Tab(selected = abaSelecionada == 0, onClick = { abaSelecionada = 0 }) {
                        Text("Todos os Shows", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold)
                    }
                    Tab(selected = abaSelecionada == 1, onClick = { abaSelecionada = 1 }) {
                        Text("Meus Favoritos ❤️", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold)
                    }
                }
            }

            // 3. Lista de Shows Filtrada
            if (showsFiltrados.isEmpty()) {
                item {
                    Box(modifier = Modifier.fillMaxWidth().padding(40.dp), contentAlignment = Alignment.Center) {
                        Text(
                            text = if (abaSelecionada == 1) "Nenhum favorito nesta cidade!" else "Nenhum show encontrado para esta seleção.",
                            color = Color.Gray
                        )
                    }
                }
            } else {
                items(showsFiltrados) { show ->
                    ItemShowCardDecorado(
                        show = show,
                        onFavoritoClick = {
                            listaShows = listaShows.map {
                                if (it.id == show.id) it.copy(isFavorito = !it.isFavorito) else it
                            }
                        },
                        onCompraClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(show.urlCompra))
                            context.startActivity(intent)
                        }
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun ItemShowCardDecorado(show: Show, onFavoritoClick: () -> Unit, onCompraClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Surface(
                        color = Color(0xFFEADDFF),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier.padding(bottom = 6.dp)
                    ) {
                        Text(
                            text = show.cidade.uppercase(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF21005D),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    Text(text = show.artista, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1C1B1F))
                    Text(text = "📍 ${show.local}", fontSize = 13.sp, color = Color.Gray)
                    Text(text = "🗓️ ${show.data}", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF6200EE))
                }

                IconButton(onClick = onFavoritoClick) {
                    val tintColor by animateColorAsState(
                        targetValue = if (show.isFavorito) Color(0xFFE91E63) else Color(0xFF9E9E9E),
                        label = "FavColor"
                    )
                    Icon(
                        imageVector = if (show.isFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = tintColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = Color(0xFFF1F1F4))
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = onCompraClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6200EE))
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Comprar Ingresso", fontWeight = FontWeight.Bold)
            }
        }
    }
}