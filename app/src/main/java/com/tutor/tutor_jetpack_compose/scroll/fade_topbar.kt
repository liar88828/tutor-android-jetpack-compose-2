package com.tutor.tutor_jetpack_compose.scroll

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun MyTopBar(
	scrollState: ScrollState,
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.verticalScroll(scrollState)
	) {
		MyBox(modifier, Color.Red, "1")
		MyBox(modifier, Color.Green, s = "2")
		MyBox(modifier, Color.Blue, s = "3")
		MyBox(modifier, Color.Yellow, s = "4")
		MyBox(modifier, Color.Magenta, s = "5")
		MyBox(modifier, Color.Cyan, s = "6")
		MyBox(modifier, Color.Gray, s = "7")
		MyBox(modifier, Color.LightGray, s = "8")
		MyBox(modifier, Color.DarkGray, s = "9")
		MyBox(modifier, Color.Black, s = "10")
		MyBox(modifier, Color.White, s = "11")
		MyBox(modifier, Color.Red, s = "12")
	}

}

@Composable
private fun MyBox(modifier: Modifier, color: Color, s: String) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.height(120.dp)
			.background(color)
	) { Text(text = s, fontSize = 30.sp) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MyScreenPrev() {
	val scrollState = rememberScrollState()
	val isScrolled by remember {
		derivedStateOf {
			scrollState.value == 0
		}
	}

	Surface(modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background,
		onClick = { }) {
		Scaffold(topBar = {
			AnimatedVisibility(
				visible = isScrolled,
				exit = slideOutVertically() + fadeOut(),
				enter = slideInHorizontally()
			) {
				TopAppBar(title = {
					Text(text = "is Change / Move ")
				})
			}
		}, content = { valuePadding ->
			MyTopBar(scrollState, Modifier)
		})
	}
}