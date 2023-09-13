package com.example.decisionmakerv2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var roomID: Long? = null,
    val text: String,

)