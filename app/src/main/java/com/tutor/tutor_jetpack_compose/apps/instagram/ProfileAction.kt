package com.tutor.tutor_jetpack_compose.apps.instagram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ProfileAction(modifier: Modifier = Modifier) {
	Row(
		modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp),
		horizontalArrangement = Arrangement.SpaceAround,
	) {
		ProfileActionButton("Following", true)
		ProfileActionButton("Message")
		ProfileActionButton("Email")
		ProfileActionButton(
			"", true,
			Icons.Outlined.Person
		)
	}
}

@Composable
private fun ProfileActionButton(
	title: String,
	icon: Boolean = false,
	iconType: ImageVector = Icons.Outlined.KeyboardArrowDown,
	modifier: Modifier = Modifier,
) {
	Button(
		shape = RoundedCornerShape(8.dp),
		contentPadding = PaddingValues(
			horizontal = 16.dp,
		),
		colors = ButtonDefaults.buttonColors(
			containerColor = Color.Gray.copy(0.3f),
			contentColor = Color.Black
		),
		onClick = { /*TODO*/ },
	) {
		if (title.isNotEmpty()) {
			Text(
				text = title,
				modifier = (modifier.padding(end = if (icon) 4.dp else 0.dp))
			)
		}

		if (icon) {
			Icon(
				imageVector = iconType,
				contentDescription = "Arrow More"
			)
		}
	}
}



