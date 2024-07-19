package com.tutor.tutor_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
					}
				}
			}
		}
	}
}

