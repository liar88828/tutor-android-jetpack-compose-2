package com.tutor.tutor_jetpack_compose.room_database.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [Note::class],
	version = 1
)
abstract class NoteDatabase : RoomDatabase() {
	abstract val dao: NoteDao

}