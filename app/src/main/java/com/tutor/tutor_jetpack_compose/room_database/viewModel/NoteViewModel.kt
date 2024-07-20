package com.tutor.tutor_jetpack_compose.room_database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tutor.tutor_jetpack_compose.room_database.roomDb.Note
import kotlinx.coroutines.launch

class NoteViewModel(
	private val repository: Repository
) : ViewModel() {
	fun getNotes() = repository.getAllNotes().asLiveData(viewModelScope.coroutineContext)

	fun upsertNote(note: Note) {
		viewModelScope.launch {
			repository.upsertNote(note)
		}
	}

	fun deleteNote(note: Note) {
		viewModelScope.launch {
			repository.deleteNote(note)
		}
	}
}