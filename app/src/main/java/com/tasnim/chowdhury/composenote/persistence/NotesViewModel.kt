package com.tasnim.chowdhury.composenote.persistence

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tasnim.chowdhury.composenote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(
    private val db: NotesDao
) : ViewModel() {

    val notes : LiveData<List<Note>> = db.getNotes()

    fun deleteNotes(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            db.deleteNote(note)
        }
    }

    fun updateNotes(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            db.updateNote(note)
        }
    }

    fun createNote(title: String, note: String, image: String? = null){
        val createNote = Note(title = title, note = note, imageUri = image)
        viewModelScope.launch(Dispatchers.IO) {
            db.insertNote(createNote)
        }
    }

}

class NoteViewModelFactory(
    private val db: NotesDao
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(
            db = db
        ) as T
    }
}