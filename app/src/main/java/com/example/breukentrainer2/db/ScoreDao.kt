package com.example.breukentrainer2.db

import android.provider.ContactsContract
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addScore(score: Score)

    @Query("SELECT * FROM score_table")
    fun getScore(): Flow<List<Score>>

    @Update
    suspend fun updateScore(score: Score)

    @Delete
    suspend fun deleteScore(score: Score)
}