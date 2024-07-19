package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
private fun MyButtonPrev() {
	MyButton()
}

@Composable
fun MyButton(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(25.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(onClick = { /*TODO*/ }) {
			Text(text = "Simple Button")
		}


		OutlinedButton(onClick = { /*TODO*/ }) {
			Text(text = "Outline Button")
		}

		IconButton(onClick = { /*TODO*/ }) {
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
				tint = MaterialTheme.colorScheme.primary,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
		}

		TextButton(onClick = { /*TODO*/ }) {
			Text(text = "Click Text")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
				tint = MaterialTheme.colorScheme.primary,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
		}

		Button(onClick = { /*TODO*/ }) {
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
//				tint = MaterialTheme.colorScheme.error,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Click Button")
		}
	}
}
