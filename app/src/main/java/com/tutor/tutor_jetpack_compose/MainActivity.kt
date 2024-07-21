package com.tutor.tutor_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.tutor.tutor_jetpack_compose.imageSelect.MyImageScreen
import com.tutor.tutor_jetpack_compose.room_database.TodoListScreen
import com.tutor.tutor_jetpack_compose.room_database.TodoListScreenData
import com.tutor.tutor_jetpack_compose.room_database.roomDb.Note
import com.tutor.tutor_jetpack_compose.room_database.roomDb.NoteDatabase
import com.tutor.tutor_jetpack_compose.room_database.viewModel.NoteViewModel
import com.tutor.tutor_jetpack_compose.room_database.viewModel.Repository
import com.tutor.tutor_jetpack_compose.screen.viewmode.MainViewModel
import com.tutor.tutor_jetpack_compose.screen.viewmode.MyApp2
import com.tutor.tutor_jetpack_compose.ui.theme.TutorjetpackcomposeTheme

class MainActivity : ComponentActivity() {
	private val db by lazy {
		Room.databaseBuilder(
			applicationContext,
			NoteDatabase::class.java,
			name = "note_database"
		).build()
	}
	private val viewModel by viewModels<NoteViewModel>(
		factoryProducer = {
			object : ViewModelProvider.Factory {
				override fun <T : ViewModel> create(modelClass: Class<T>): T {
					@Suppress("UNCHECKED_CAST")
					return NoteViewModel(Repository(db)) as T
				}
			}
		}
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			TutorjetpackcomposeTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Surface(
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding),
						color = MaterialTheme.colorScheme.background
					) {
						RoomDataBaseScreen(viewModel)
						MyImageScreen()
					}
				}
			}
		}
	}

	@Composable
	private fun RoomDataBaseScreen(viewModel: NoteViewModel) {
		var noteList by remember { mutableStateOf(listOf<Note>()) }
		viewModel.getNotes().observe(this) { noteList = it }

		fun handlerCreate(title: String, body: String) {
			viewModel.upsertNote(Note(title, body))
		}

		fun handlerDelete(note: Note) {
			viewModel.deleteNote(note)
		}

		TodoListScreen(
			TodoListScreenData(
				noteList,
				handlerDelete = ::handlerDelete,
				handlerCreate = ::handlerCreate
			)
		)
	}

	@Composable
	fun Screen1() {
		val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
		var count by remember {
			mutableIntStateOf(viewModel.count)
		}
		LazyColumn {
			items(1) {
				Column(
					modifier = Modifier.fillMaxSize(),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					Text(text = "count is state $count")
					Text(text = "count view model is ${viewModel.count}")
					Spacer(modifier = Modifier.height(16.dp))
					Button(onClick = {
						viewModel.increment()
						count++
						//								count = viewModel.count
					}) {
						Text(text = "Click me")
					}
				}
				MyApp2(viewModel = viewModel)
			}
		}
	}
}

