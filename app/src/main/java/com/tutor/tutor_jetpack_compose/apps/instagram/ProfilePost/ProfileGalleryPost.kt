package com.tutor.tutor_jetpack_compose.apps.instagram.ProfilePost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.R

@Composable
fun ProfileGalleryPost(
	scrollState: LazyGridState,
	modifier: Modifier = Modifier
) {
//	Text(
//		text = "Scroll Offset: $scrollOffset",
//		modifier = Modifier.padding(8.dp)
//	)
	Box(
		modifier = modifier
			.fillMaxSize()
	) {
		LazyVerticalGrid(
			columns = GridCells.Fixed(3),
			state = scrollState,
			modifier = Modifier.fillMaxSize(),
		) {
			items(imageUrls.size) { index ->
				val imageUrl = imageUrls[index]
				Image(
					painter = painterResource(imageUrl),
					contentDescription = "Gallery Image $index",
					modifier = Modifier
						.padding(4.dp)
						.clip(RoundedCornerShape(8.dp))
						.fillMaxSize(),
					contentScale = ContentScale.Crop
				)
			}
		}
	}
}

private val imageUrls = listOf(
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
)
