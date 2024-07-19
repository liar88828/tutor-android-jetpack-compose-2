package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun StylingTextField() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.LightGray)
			.padding(top = 40.dp),
		contentAlignment = Alignment.Center
	) {
		val textState = remember { mutableStateOf("") }

		TextField(
			modifier = Modifier.padding(top = 20.dp),
			label = { Text(text = "Enter your name") },
			leadingIcon = {
				Icon(
					imageVector = Icons.Default.Email,
					contentDescription = "Email Icon"
				)
			},
			trailingIcon = {
				Icon(
					imageVector = Icons.Default.AddCircle,
					contentDescription = "Add Circle"
				)
			},
			colors = TextFieldDefaults.colors(
				unfocusedTextColor = Color.Red,
				focusedTextColor = Color.Blue,
				cursorColor = Color.Yellow,
//				textState = Color.Green,
				focusedIndicatorColor = Color.Red,
				unfocusedIndicatorColor = Color.Blue,
				focusedLabelColor = Color.Red,
				unfocusedLabelColor = Color.Blue,
				focusedContainerColor = Color.Blue,
				unfocusedContainerColor = Color.Red
			),
			shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
			value = textState.value,
			onValueChange = { textState.value = it }
		)
	}

}