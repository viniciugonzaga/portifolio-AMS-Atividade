package com.example.myapplication

data class Show(
    val id: Int,
    val artista: String,
    val cidade: String,
    val local: String,
    val data: String,
    val isFavorito: Boolean = false, // CORRIGIDO: Nome limpo e usando 'val'
    val urlCompra: String = ""
)