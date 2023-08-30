package com.example.decisionmakerv2.data.repository

import com.example.decisionmakerv2.data.NoteDao
import com.example.decisionmakerv2.model.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteDao: NoteDao
){
    fun getAllFlow(): Flow<List<NoteEntity>> = noteDao.getAllFlow()
    suspend fun insert(note: NoteEntity) = noteDao.insert(note = note)
    suspend fun choose(note: NoteEntity) = noteDao.choose(note = note)
    suspend fun delete(note: NoteEntity) = noteDao.delete(note = note)

}