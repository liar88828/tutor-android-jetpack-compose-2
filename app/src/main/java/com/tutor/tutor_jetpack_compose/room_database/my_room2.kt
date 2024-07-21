package com.tutor.tutor_jetpack_compose.room_database

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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.room_database.roomDb.Note

@Composable
fun TodoListScreen2(
) {
	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		var title by remember { mutableStateOf("") }
		var body by remember { mutableStateOf("") }
		var listData by remember {
			mutableStateOf(
				listOf<Note>(
					Note("Body 1", "Title 1", 1)
				)
			)
		}

		fun handlerCreate(
			title: String = "noting",
			body: String = "noting",
			id: Int = title.length + body.length
		) {
			listData = listData + Note(title, body, 1)

		}

		fun handlerDelete(note: Note) {
			listData = listData - note
		}
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			TextField(
				modifier = Modifier.fillMaxWidth(),
				label = { Text("Title") },
				placeholder = { Text("Add Title") },
				value = title,
				onValueChange = { title = it }
			)
			TextField(
				modifier = Modifier.fillMaxWidth(),
				label = { Text("Body") },
				placeholder = { Text("Add Body") },
				value = body,
				onValueChange = { body = it }
			)

			Button(
				modifier = Modifier.fillMaxWidth(),
				onClick = { handlerCreate(title, body) }) {
				Text(text = "Save Data")
			}
			Text(text = title)
			Text(text = body)
		}
		LazyColumn {
			items(listData) { note ->
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
						IconButton(onClick = { handlerDelete(note) }) {
							Icon(
								imageVector = Icons.Default.Delete,
								contentDescription = "Delete icons"
							)
						}
					}
				}
				HorizontalDivider(
					Modifier
						.fillMaxWidth()
						.padding(horizontal = 16.dp)
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun TodoListScreenPrev() {
	TodoListScreen2()
}
 