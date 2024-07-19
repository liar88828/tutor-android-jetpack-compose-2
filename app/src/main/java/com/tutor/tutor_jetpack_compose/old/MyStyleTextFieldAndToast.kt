package com.tutor.tutor_jetpack_compose.old

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
private fun MyStyleTextFieldAndToast() {
	val newText = remember {
		mutableStateOf("")
	}
	val context = LocalContext.current
	val keyboardController = LocalSoftwareKeyboardController.current
	val focusManager = LocalFocusManager.current
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
			OutlinedTextField(
				label = { Text(text = "Enter your name") },
				placeholder = { Text(text = "Is Placeholder") },
				maxLines = 2,
				singleLine = true,
				modifier = Modifier.width(300.dp),
//				visualTransformation = PasswordVisualTransformation(),
				leadingIcon = {
					Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
				},
				trailingIcon = {
					IconButton(onClick = {
						Toast.makeText(context, newText.value, Toast.LENGTH_SHORT).show()
					}) {
						Icon(
							imageVector = Icons.Default.AddCircle,
							contentDescription = "Add Circle"
						)
					}
				},
				value = newText.value,
				onValueChange = { newText.value = it },
				keyboardOptions = KeyboardOptions(
					capitalization = KeyboardCapitalization.Characters,
					keyboardType = KeyboardType.Phone,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(
//					onNext = {
////						keyboardController?.hide()
//					}
				)
//				keyboardType = KeyboardType.Email
			)

			TextField(
				label = { Text(text = "Enter your name") },
				placeholder = { Text(text = "Is Placeholder") },
				maxLines = 2,
				singleLine = true,
				modifier = Modifier.width(300.dp),
				visualTransformation = PasswordVisualTransformation(), leadingIcon = {
					Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
				},
				trailingIcon = {
					IconButton(onClick = {
						Toast.makeText(context, newText.value, Toast.LENGTH_SHORT).show()
					}) {
						Icon(
							imageVector = Icons.Default.AddCircle,
							contentDescription = "Add Circle"
						)
					}
				},
				value = newText.value, onValueChange = { newText.value = it },
				keyboardOptions = KeyboardOptions(
					capitalization = KeyboardCapitalization.Characters,
					keyboardType = KeyboardType.Text,
					imeAction = ImeAction.Send
				),
				keyboardActions = KeyboardActions(
					onSend = {
//						will hide keyboard
						keyboardController?.hide()
//						send toast
						Toast.makeText(context, newText.value, Toast.LENGTH_SHORT).show()
//				close text field
						focusManager.clearFocus()
					}
				))


			BasicTextField(
				modifier = Modifier
					.width(300.dp)
					.background(Color.LightGray),
				value = "Hello",
				onValueChange = {})

			Text(text = newText.value)
		}
	}
}