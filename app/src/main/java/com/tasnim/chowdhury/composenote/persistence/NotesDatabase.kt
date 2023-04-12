package com.tasnim.chowdhury.composenote.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tasnim.chowdhury.composenote.model.Note

@Database(version = 1, entities = [Note::class], exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun NotesDao() : NotesDao
}