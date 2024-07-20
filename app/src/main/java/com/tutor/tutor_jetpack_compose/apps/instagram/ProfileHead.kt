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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R

@Composable
fun ProfileHead(modifier: Modifier = Modifier) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(bottom = 8.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_background),
			contentDescription = "Image Profile",
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.size(68.dp)
				.clip(shape = CircleShape)
				.border(
					width = 2.dp, color = MaterialTheme.colorScheme.primary,
					shape = CircleShape
				)
				.border(
					width = 4.dp, color = Color.White,
					shape = CircleShape
				)
		)
		ProfileStatic(num = 5, title = "Posts")
		ProfileStatic(num = 200, title = "Followers")
		ProfileStatic(num = 99, title = "Following")
	}

}

@Composable
private fun ProfileStatic(num: Int, title: String) {
	Column(
		modifier = Modifier.padding(16.dp),
		verticalArrangement = Arrangement.spacedBy(4.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = "$num",
			fontWeight = FontWeight.Bold,
			fontSize = 18.sp
		)
		Text(
			text = title,
			fontWeight = FontWeight.SemiBold,
			fontSize = 12.sp
		)
	}
}
