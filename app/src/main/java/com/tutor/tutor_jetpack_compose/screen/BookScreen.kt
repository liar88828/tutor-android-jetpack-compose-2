package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R

data class BookData(
	val image: Int,
	val title: String,
)

val bookList = listOf(
	BookData(
		title = "Timothy Deng",
		image = R.drawable.ic_launcher_background
	),
	BookData(
		title = "Anne Deng",
		image = R.drawable.ic_launcher_foreground
	),
	BookData(
		title = "Sergio Mondal",
		image = R.drawable.ic_launcher_background
	),
	BookData(
		title = "MargaretUmar",
		image = R.drawable.ic_launcher_foreground
	),
	BookData(
		title = "Yuanyuan Ruiz",
		image = R.drawable.ic_launcher_background
	),
	BookData(
		title = "Silvia Lian",
		image = R.drawable.ic_launcher_foreground
	),
	BookData(
		title = "Na Castillo",
		image = R.drawable.ic_launcher_background
	),
	BookData(
		title = "Shanti Mostafa",
		image = R.drawable.ic_launcher_foreground
	),
)

@Composable
fun ItemBookScreen(
	modifier: Modifier = Modifier,
	item: BookData
) {
	Card(
		modifier = modifier
			.padding(10.dp),
		shape = RoundedCornerShape(4.dp),
		colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
		elevation = CardDefaults.cardElevation(2.dp),
		onClick = {},
	) {
		Column(
			modifier = modifier,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Image(
				modifier = modifier
					.height(120.dp)
					.width(100.dp),
				contentScale = ContentScale.Crop,
				painter = painterResource(id = item.image),
				contentDescription = item.title
			)
			Column(
				modifier = modifier.padding(5.dp),
			) {
				Text(
					text = item.title,
					fontWeight = FontWeight.Bold,
					fontSize = 14.sp
				)
			}
		}
	}
}

@Composable
fun BookScreen(
	modifier: Modifier = Modifier, title: String,
	itemData: List<BookData>
) {
	Card(
		modifier = modifier.padding(vertical = 10.dp),
		elevation = CardDefaults.cardElevation(2.dp),
		colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
		) {
		Text(
			modifier = modifier.padding(
				start = 10.dp,
				top = 10.dp
			),
			text = title,
			fontWeight = FontWeight.Bold,
			fontSize = 20.sp
		)
		LazyRow(
			contentPadding = PaddingValues(5.dp),
			horizontalArrangement = Arrangement.spacedBy(5.dp)
		) {
			items(itemData) {
				ItemBookScreen(item = it)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun BookScreenPrev() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		LazyColumn(modifier = Modifier.padding(10.dp)) {
			items(1) {
				BookScreen(title = "Best Seller", itemData = bookList)
				BookScreen(title = "Recommended", itemData = bookList)
				BookScreen(title = "New Product", itemData = bookList)
				BookScreen(title = "Less Price", itemData = bookList)
				BookScreen(title = "big sale", itemData = bookList)
			}
		}
	}

}