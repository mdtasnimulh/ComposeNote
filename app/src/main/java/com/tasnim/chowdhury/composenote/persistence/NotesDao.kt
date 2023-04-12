package com.tasnim.chowdhury.composenote.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tasnim.chowdhury.composenote.model.Note

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes WHERE notes.id=:id")
    suspend fun getNotesById(id: Int): Note?

    @Query("SELECT * FROM Notes ORDER BY dateUpdated DESC")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Insert
    suspend fun insertNote(note: Note)
}