package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(modifier: Modifier = Modifier) {
	Scaffold(
		topBar = {
			TopAppBar(title = { Text(text = "Top Bar") })
		},
		bottomBar = {
			BottomAppBar {
				Text(text = "Bottom Bar")
			}
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
			}
		},
	) { paddingValues ->
		Column(modifier = Modifier.padding(paddingValues)) {
			Text(text = "Content")
		}
	}
}

@Preview
@Composable
private fun MyScaffoldPrev() {
	MyScaffold()

}