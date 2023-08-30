package com.example.decisionmakerv2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.decisionmakerv2.data.repository.NoteRepository
import com.example.decisionmakerv2.model.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelAbstract{
    val noteListFlow: Flow<List<NoteEntity>>
    fun addNote(note: NoteEntity)
    fun chooseNote(note: NoteEntity)
    fun deleteNote(note: NoteEntity)
}

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val noteRepository: NoteRepository,
): ViewModel(), HomeViewModelAbstract {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    override val noteListFlow: Flow<List<NoteEntity>> = noteRepository.getAllFlow()

    override fun addNote(note: NoteEntity) {ioScope.launch { noteRepository.insert(note = note) }}

    override fun chooseNote(note: NoteEntity) {ioScope.launch { noteRepository.insert(note = note) }}

    override fun deleteNote(note: NoteEntity) {ioScope.launch { noteRepository.delete(note = note) }}

}