package com.example.rastreador_shows.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shows")
data class ShowEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val artista: String,
    val data: String,
    val local: String,
    val valorIngresso: Double,
    val userEmail: String // Vincula diretamente o show ao e-mail de quem criou
)