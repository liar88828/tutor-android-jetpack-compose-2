package com.tutor.tutor_jetpack_compose.room_database.viewModel

import com.tutor.tutor_jetpack_compose.room_database.roomDb.Note
import com.tutor.tutor_jetpack_compose.room_database.roomDb.NoteDao
import com.tutor.tutor_jetpack_compose.room_database.roomDb.NoteDatabase
import kotlinx.coroutines.flow.Flow

class Repository(
	private val db: NoteDatabase
) : NoteDao {
	override suspend fun upsertNote(note: Note) {
		db.dao.upsertNote(note)
	}

	override suspend fun deleteNote(note: Note) {
		db.dao.deleteNote(note)

	}

	override fun getAllNotes(): Flow<List<Note>> {
		return db.dao.getAllNotes()
	}

}