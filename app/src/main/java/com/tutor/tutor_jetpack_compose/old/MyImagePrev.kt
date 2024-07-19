package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.R

@Preview(showBackground = true)
@Composable
private fun MyImagePrev() {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(
			modifier = Modifier
				.padding(10.dp)
				.size(200.dp)
				.clip(CutCornerShape(20.dp))
				.border(2.dp, Color.Red, shape = CutCornerShape(20.dp)),
			alignment = Alignment.Center,
			painter = painterResource(id = R.drawable.ic_launcher_background),
			contentDescription = "My Image",
			contentScale = ContentScale.Crop,
			alpha = 0.5f// blur
		)
		Image(
			modifier = Modifier
				.padding(10.dp)
				.size(200.dp)
				.clip(CircleShape)
				.border(2.dp, Color.Red, shape = CircleShape),
			alignment = Alignment.Center,
			painter = painterResource(id = R.drawable.ic_launcher_background),
			contentDescription = "My Image",
			contentScale = ContentScale.Crop,
			alpha = 0.5f// blur
		)

		Image(
			modifier = Modifier
				.padding(10.dp)
				.size(200.dp)
				.clip(RoundedCornerShape(20.dp))
				.border(2.dp, Color.Red, shape = RoundedCornerShape(20.dp)),
			alignment = Alignment.Center,
			painter = painterResource(id = R.drawable.ic_launcher_background),
			contentDescription = "My Image",
			contentScale = ContentScale.Crop,
			alpha = 0.5f// blur
		)
	}

}