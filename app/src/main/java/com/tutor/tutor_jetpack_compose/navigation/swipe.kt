package com.tutor.tutor_jetpack_compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeScreen(modifier: Modifier = Modifier) {
	val list = remember {
		mutableListOf(
			"Subscribe",
			"Like",
			"Comment",
			"Share",
			"Save",
			"Report",
			"Block",
			"Unblock",
		)
	}

	LazyColumn(
		state = rememberLazyListState(),
		contentPadding = PaddingValues(10.dp),
		modifier = modifier.fillMaxSize()
	) {
		itemsIndexed(items = list,
			key = { _, listItem ->
				listItem.hashCode()
			}) { index, item ->
			val state = rememberSwipeToDismissBoxState(
				confirmValueChange = {
//					Change to confirm value
					if (it == SwipeToDismissBoxValue.StartToEnd) {
//						list.remove(item)
					}
					if (it == SwipeToDismissBoxValue.EndToStart) {
						list.remove(item)
					}
					true
				}
			)

			SwipeToDismissBox(
				state = state,
				backgroundContent = {
					val color = when (state.dismissDirection) {
						SwipeToDismissBoxValue.StartToEnd -> Color.Green
						SwipeToDismissBoxValue.EndToStart -> Color.Red
						else -> Color.Transparent
					}
					Box(
						modifier = Modifier
							.fillMaxSize()
							.background(color)
							.padding(horizontal = 10.dp)
							.clip(shape = RoundedCornerShape(10.dp)),
					)
					{
						Icon(
							imageVector = Icons.Default.Edit,
							contentDescription = "Edit Icons",
							modifier = Modifier.align(Alignment.CenterStart),
						)
						Icon(
							imageVector = Icons.Default.Delete,
							contentDescription = "Delete Icons",
							modifier = Modifier.align(Alignment.CenterEnd),
						)
					}
				},
				content = {
					ItemUI(text = list, itemIndex = index)
				}
			)
//			ItemUI(
//				text = list,
//				itemIndex = index
//			)
		}
	}

}

@Composable
fun ItemUI(text: List<String>, itemIndex: Int) {
	Card(modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(10.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = text[itemIndex], fontSize = 32.sp, fontWeight = FontWeight.Bold)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun SwipeScreenPrev() {
	SwipeScreen()
}