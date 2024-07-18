package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R

@Preview(showBackground = true)
@Composable
private fun MyCardPrev() {
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Card(
			modifier = Modifier
				.width(200.dp)
				.height(270.dp),
//			shape = RoundedCornerShape(20.dp),
			elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
			border = BorderStroke(1.dp, Color.Gray),
			colors = CardDefaults.cardColors(
				containerColor = Color.White,
//				contentColor = Color.Red
			),
		) {
			Column(
				modifier = Modifier.fillMaxSize()
			) {
				Image(
					painter = painterResource(id = R.drawable.ic_launcher_background),
					contentDescription = "Is Image",
					modifier = Modifier
						.fillMaxWidth()
						.height(160.dp),
					contentScale = ContentScale.Crop
				)
				Text(
					text = "Title",
					fontWeight = FontWeight.Bold,
					fontSize = 18.sp,
					modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
				)
				Text(
					fontWeight = FontWeight.Normal,
					fontSize = 15.sp,
					modifier = Modifier.padding(start = 10.dp),
					text = "lorem ipsum dolor sit amet, consectetur adipiscing elit.",
					maxLines = 3,
					color = Color.LightGray
				)
			}
		}
	}
}