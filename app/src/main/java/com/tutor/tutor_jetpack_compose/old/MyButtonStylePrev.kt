package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, name = "MyButtonStyle")
@Composable
private fun MyButtonStylePrev() {
	MyButtonStyle()
}

@Composable
private fun MyButtonStyle(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp, 60.dp),
		verticalArrangement = Arrangement.spacedBy(20.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(
			shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
			onClick = { /*TODO*/ },
		) { Text(text = "Rounded corner button") }


		Button(
			shape = CutCornerShape(topStart = 10.dp, bottomEnd = 10.dp), onClick = { /*TODO*/ },
		) { Text(text = "Cut corner button") }

		Button(
			shape = CircleShape, onClick = { /*TODO*/ },
		) {
			Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Circle")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Cut corner button")
		}


		Button(
			shape = RoundedCornerShape(10.dp),
			elevation = ButtonDefaults.buttonElevation(
				defaultElevation = 10.dp,
				pressedElevation = 6.dp
			),
			colors = ButtonDefaults.buttonColors(
				containerColor = Color.Red,
				contentColor = Color.Yellow
			),
			border = BorderStroke(8.dp, Color.Green),
			onClick = { /*TODO*/ },
		) {
			Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Circle")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Cut corner button")
		}
	}
}
