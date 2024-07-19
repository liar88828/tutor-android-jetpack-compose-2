package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val languages = listOf(
	"Java", "Kotlin", "Python", "C++", "C", "JavaScript", "HTML", "R", "CSS", "PHP", "Go"
)

@Preview(showBackground = true)
@Composable
private fun MyLazyColumnPrev() {
	MyLazyRow(lang = languages)
}

@Composable
fun MyLazyRow(modifier: Modifier = Modifier, lang: List<String>) {
	Column(modifier = modifier.fillMaxSize()) {
		LazyRow(contentPadding = PaddingValues(10.dp)) {
			items(lang) { RowItem(name = it) }
		}

		LazyColumn(contentPadding = PaddingValues(10.dp)) {
			items(lang) { ColumnItem(name = it) }
		}
	}
}

@Composable
private fun ColumnItem(modifier: Modifier = Modifier, name: String) {
	Card(
		modifier = modifier
			.padding(10.dp)
			.fillMaxWidth()
			.wrapContentHeight()
			.aspectRatio(3f),
		colors = CardDefaults.cardColors(containerColor = Color.White),
		elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
	) {
		Box(
			modifier = modifier
				.padding(10.dp)
				.fillMaxSize(), contentAlignment = Alignment.Center
		) {
			Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
		}
	}
}

@Composable
private fun RowItem(modifier: Modifier = Modifier, name: String) {
	Card(
		modifier = modifier
			.padding(10.dp)
			.fillMaxWidth()
			.height(100.dp)
			.aspectRatio(1.5f),
		colors = CardDefaults.cardColors(containerColor = Color.White),
		elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
	) {
		Box(
			modifier = modifier
				.padding(10.dp)
				.fillMaxSize(), contentAlignment = Alignment.Center
		) {
			Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
		}
	}
}
