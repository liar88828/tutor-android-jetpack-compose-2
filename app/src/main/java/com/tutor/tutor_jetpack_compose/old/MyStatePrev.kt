package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, name = "MyState")
@Composable
private fun MyStatePrev() {
	MyState()
}

@Composable
private fun MyState(modifier: Modifier = Modifier) {
	val count = remember {
		mutableIntStateOf(0)
	}
	val multipleCount = remember {
		mutableIntStateOf(0)
	}

	fun increment() {
		count.intValue++
	}

	fun multipleIncrement() {
		count.intValue += multipleCount.intValue
	}

	fun decrement() {
		if (count.intValue > 0) {
			count.intValue--
		}
	}

	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TextField(
			value = multipleCount.intValue.toString(),
			onValueChange = { multipleCount.intValue = it.toInt() })
		Button(onClick = { decrement() }) {
			Text(text = "Click Decrement ")
		}

		Text(text = count.intValue.toString())

		Button(onClick = { increment() }) {
			Text(text = "Click Increment ")
		}
		Button(onClick = { multipleIncrement() }) {
			Text(text = "Click Increment ${multipleCount.intValue}")
		}
	}
}
