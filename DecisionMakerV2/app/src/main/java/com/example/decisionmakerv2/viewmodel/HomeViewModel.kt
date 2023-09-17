package com.example.decisionmakerv2.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    suspend fun chooseNote()

    suspend fun deleteAll()

    fun deleteNote(note: NoteEntity)

    fun onInputValueChange()

}

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val noteRepository: NoteRepository,
): ViewModel(), HomeViewModelAbstract {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _chosenNote = mutableStateOf<String?>(null)
    var chosenNote: MutableState<String?> = _chosenNote

    var inputValue: String = ""

    override val noteListFlow: Flow<List<NoteEntity>> = noteRepository.getAllFlow()

    override fun addNote(note: NoteEntity) {ioScope.launch { noteRepository.insert(note = note) }}

    override suspend fun chooseNote() {
        val selectedNote = noteRepository.chooseNote()
        _chosenNote.value = selectedNote
    }

    override suspend fun deleteAll() {
        ioScope.launch { noteRepository.deleteAll() }
    }

    override fun deleteNote(note: NoteEntity) {
        ioScope.launch { noteRepository.delete(note = note) }
    }

    override fun onInputValueChange() {
        inputValue = ""
    }

}