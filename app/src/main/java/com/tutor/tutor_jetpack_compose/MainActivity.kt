package com.tutor.tutor_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.tutor.tutor_jetpack_compose.screen.viewmode.MainViewModel
import com.tutor.tutor_jetpack_compose.screen.viewmode.MyApp2
import com.tutor.tutor_jetpack_compose.ui.theme.TutorjetpackcomposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			TutorjetpackcomposeTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Surface(
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding),
						color = MaterialTheme.colorScheme.background
					) {
						val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
						var count by remember {
							mutableIntStateOf(viewModel.count)
						}
						LazyColumn {
							items(1) {
								Column(
									modifier = Modifier.fillMaxSize(),
									horizontalAlignment = Alignment.CenterHorizontally,
									verticalArrangement = Arrangement.Center
								) {
									Text(text = "count is state $count")
									Text(text = "count view model is ${viewModel.count}")
									Spacer(modifier = Modifier.height(16.dp))
									Button(onClick = {
										viewModel.increment()
										count++
//								count = viewModel.count
									}) {
										Text(text = "Click me")
									}
								}
								MyApp2(viewModel = viewModel)
							}
						}
					}
				}
			}
		}
	}
}

