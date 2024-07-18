package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val listProgramingLanguage = listOf(
	"Kotlin",
	"Java",
	"Python",
	"C++",
	"C",
	"JavaScript",
	"Ruby",
	"Go",
	"Rust",
	"Swift",
	"Scala",
	"TypeScript",
	"PHP",
	"Perl",
	"R",
)

@Composable
fun SearchItem(
	modifier: Modifier = Modifier,
	searchText: MutableState<String>,
	item: List<String>
) {
	val searchData = item.filter {
		it.contains(searchText.value, ignoreCase = true)
	}

	LazyColumn(
		contentPadding = PaddingValues(10.dp)
	) {
		items(searchData.size) { index ->
			Column(
				modifier = modifier
					.fillMaxWidth()
					.padding(10.dp)
			) {
				Row {
					Text(text = "$index. ")
					Text(text = searchData[index])
				}
				HorizontalDivider(color = Color.DarkGray)
			}
		}
	}
}

@Composable
fun SearchField(
	modifier: Modifier = Modifier,
	searchText: MutableState<String>
) {
	TextField(
		colors = TextFieldDefaults.colors(
			focusedTextColor = Color.Blue,
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent,
//			unfocusedBorderColor = Color.Gray
		),
		modifier = modifier
			.fillMaxWidth()
			.padding(10.dp),
		shape = RoundedCornerShape(10.dp),
		label = { Text(text = "Search") },
		placeholder = { Text(text = "Search like Kotlin") },
		value = searchText.value, onValueChange = { searchText.value = it })
}

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
	val searchText = remember { mutableStateOf("") }

	Column(modifier = modifier.padding(10.dp)) {
		SearchField(searchText = searchText)
		Card(
			modifier = modifier
				.fillMaxSize()
				.padding(10.dp),
			colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
		) {
			SearchItem(
				searchText = searchText, item = listProgramingLanguage
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPrev() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		SearchScreen()
	}
}