package com.example.decisionmakerv2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.decisionmakerv2.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("select * from note")
    fun getAllFlow(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity)

    @Query("SELECT text FROM note ORDER BY RANDOM() LIMIT 1")
    suspend fun chooseNote(): String?

    @Delete
    suspend fun delete(note: NoteEntity)

    @Query("DELETE FROM note")
    suspend fun deleteAll()

}