package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import kotlin.random.Random

@Composable
private fun MyCardVertical(item: Int, modifier: Modifier) {
	Card(
		modifier = modifier
			.size(100.dp)
			.padding(6.dp),
		elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
		colors = CardDefaults.cardColors(
			containerColor = Color(
				Random.nextFloat(),
				Random.nextFloat(),
				Random.nextFloat(),
				1f
			)
//				.copy(alpha = 0.5f)
		)
	) {
		Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
			Text(text = item.toString(), fontSize = 22.sp, fontWeight = FontWeight.Bold)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun MyLazyGrid() {
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(16.dp)
	) {
		items(100) {
//			Text(text = "Item $it", textAlign = TextAlign.Center)
			MyCardVertical(it, Modifier)
		}
	}
}