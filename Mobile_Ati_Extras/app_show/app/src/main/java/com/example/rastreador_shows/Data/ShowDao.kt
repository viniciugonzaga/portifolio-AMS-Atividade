package com.example.rastreador_shows.Data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {
    // Busca apenas os shows cadastrados pela conta do e-mail fornecido
    @Query("SELECT * FROM shows WHERE userEmail = :email ORDER BY data ASC")
    fun getShowsByUser(email: String): Flow<List<ShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShow(show: ShowEntity)

    @Update
    suspend fun updateShow(show: ShowEntity)

    @Delete
    suspend fun deleteShow(show: ShowEntity)
}