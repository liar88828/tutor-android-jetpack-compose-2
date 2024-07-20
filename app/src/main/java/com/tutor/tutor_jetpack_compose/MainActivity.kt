package com.tutor.tutor_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
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
//						Screen1()
						var title = remember {
							mutableStateOf("")
						}
						var body = remember {
							mutableStateOf("")
						}
						val note = Note(title.value, body.value)
						var noteList by remember {
							mutableStateOf(listOf<Note>())
						}
						viewModel.getNotes().observe(this) {
							noteList = it
						}


						Column(
							modifier = Modifier.fillMaxSize(),
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							FormNote(title, body, handleSave = { viewModel.upsertNote(note) })
							LoopNote(noteList, viewModel)
						}
					}
				}
			}
		}
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

@Composable
private fun RowData(note: Note, handlerDelete: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Column(modifier = Modifier.padding(2.dp)) {
			Text(text = "Name : ${note.title}")
			Spacer(modifier = Modifier.height(6.dp))
			Text(text = "Name : ${note.body}")
		}
		Column {
			IconButton(onClick = { handlerDelete() }) {
				Icon(
					imageVector = Icons.Default.Delete,
					contentDescription = "Delete icons"
				)
			}
		}
	}
}

@Composable
private fun FormNote(
	title: MutableState<String>,
	body: MutableState<String>,
	handleSave: () -> Unit
) {
	var title1 = title
	var body1 = body
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		TextField(
			modifier = Modifier.fillMaxWidth(),
			label = { Text("Title") },
			placeholder = { Text("Add Title") },
			value = title1.value,
			onValueChange = { title1.value = it }
		)
		TextField(
			modifier = Modifier.fillMaxWidth(),
			label = { Text("Body") },
			placeholder = { Text("Add Body") },
			value = body1.value,
			onValueChange = { body1.value = it }
		)

		Button(
			modifier = Modifier.fillMaxWidth(),
			onClick = { handleSave() }) {
			Text(text = "Save Data")
		}
	}
}

@Composable
private fun LoopNote(
	noteList: List<Note>,
	viewModel: NoteViewModel
) {
	LazyColumn {
		items(noteList) { note ->
			RowData(note, handlerDelete = { viewModel.deleteNote(note) })
			HorizontalDivider(
				Modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun FormNotePrev() {
	var title = remember {
		mutableStateOf("")
	}
	var body = remember {
		mutableStateOf("")
	}
	FormNote(
		title = title,
		body = body,
		handleSave = {}
	)
}

@Preview(showBackground = true)
@Composable
private fun RowDataPrev() {
	RowData(note = Note(
		title = "Test",
		body = "Test Body",
	), handlerDelete = {})

}