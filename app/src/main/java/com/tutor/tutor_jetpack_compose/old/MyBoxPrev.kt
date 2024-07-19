package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, name = "MyBox")
@Composable
private fun MyBoxPrev() {
	MyBox()
}

@Composable
private fun MyBox(modifier: Modifier = Modifier) {
	Box(
		modifier = modifier
			.background(MaterialTheme.colorScheme.primary)
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Box(
			modifier = modifier
				.background(MaterialTheme.colorScheme.secondary)
				.width(250.dp)
				.height(250.dp),
			contentAlignment = Alignment.BottomEnd
		) {
			Box(
				modifier = modifier
					.background(MaterialTheme.colorScheme.tertiary)
//					.width(100.dp)
					.height(100.dp)
			) {
				Text(text = "Subscribe please", fontSize = 28.sp)
			}
		}
	}
}
