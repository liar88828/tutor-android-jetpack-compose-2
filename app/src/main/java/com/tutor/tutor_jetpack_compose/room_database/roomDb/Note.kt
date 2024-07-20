package com.tutor.tutor_jetpack_compose.room_database.roomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
	val title: String,
	val body: String,
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0
)
