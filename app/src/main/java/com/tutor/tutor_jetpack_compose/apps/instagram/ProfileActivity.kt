package com.tutor.tutor_jetpack_compose.apps.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.R

@Composable
fun ProfileActivity() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp)
	) {
		ProfileActivityStatus(
			image = R.drawable.ic_launcher_background,
			title = "Monday",
		)
		ProfileActivityStatus(
			image = R.drawable.ic_launcher_foreground,
			title = "Thursday",
		)
	}
}

@Composable
private fun ProfileActivityStatus(image: Int, title: String) {
	Column(
//		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(
			painter = painterResource(id = image),
			contentDescription = "Image Profile",
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.size(64.dp)
				.clip(shape = CircleShape)
				.border(
					width = 2.dp, color = Color.LightGray,
					shape = CircleShape
				)
				.border(
					width = 4.dp, color = Color.White,
					shape = CircleShape
				)
		)

		Text(
			text = title,
			fontWeight = FontWeight.Normal,
			modifier = Modifier.padding(top = 4.dp),
			color = Color.Gray.copy(0.8f)
		)
	}
}
