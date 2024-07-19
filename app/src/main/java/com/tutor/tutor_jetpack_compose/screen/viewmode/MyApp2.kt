package com.tutor.tutor_jetpack_compose.screen.viewmode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//save ViewModel clean architecture
@Composable
fun MyApp2(
	modifier: Modifier = Modifier,
	viewModel: MainViewModel
) {
	var count by remember {
		mutableIntStateOf(viewModel.count)
	}

	Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Text(text = "count is $count")
			Text(text = "count is ${viewModel.count}")
			Spacer(modifier = Modifier.height(16.dp))
			Button(onClick = {
				viewModel.increment()
				count++
			}) {
				Text(text = "Click me")
			}
		}
	}
}
//@Preview(showBackground = true)
//@Composable
//private fun MyApp2Prev() {
//	val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//
//	MyApp2(viewModel = viewModel)
//}