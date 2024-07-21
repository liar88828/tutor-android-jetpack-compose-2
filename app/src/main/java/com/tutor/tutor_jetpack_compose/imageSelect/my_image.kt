package com.tutor.tutor_jetpack_compose.imageSelect

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MyImageScreen(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
	) {
		var selectImageUrl by remember {
			mutableStateOf<Uri?>(null)
		}
		var selectedImageUrlList by remember {
			mutableStateOf<List<Uri>>(emptyList())
		}
		val singleImagePickerLauncher =
			rememberLauncherForActivityResult(
				contract = ActivityResultContracts.PickVisualMedia(),
				onResult = { uri -> selectImageUrl = uri })
		val multipleImagePickerLauncher =
			rememberLauncherForActivityResult(
				contract = ActivityResultContracts.PickMultipleVisualMedia(),
				onResult = { uriList -> selectedImageUrlList = uriList })



		Column(
			modifier = Modifier.fillMaxSize(),
		) {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(12.dp),
				horizontalArrangement = Arrangement.SpaceAround
			) {
				Button(onClick = {
					singleImagePickerLauncher.launch(
						PickVisualMediaRequest(ImageOnly)
					)
				}) {
					Text(text = "Pick Single Image")
				}
				Button(onClick = {
					multipleImagePickerLauncher.launch(
						PickVisualMediaRequest(ImageOnly)
					)
				}) {
					Text(text = "Pick Multiple Image")
				}
			}
			LazyColumn(
				modifier = modifier
					.fillMaxSize()
					.padding(12.dp),
			) {
				item {
					AsyncImage(
						model = selectImageUrl,
						contentDescription = "Selected Image",
						modifier = modifier.fillMaxWidth(),
						contentScale = ContentScale.Crop
					)
					HorizontalDivider(
						modifier = modifier
							.fillMaxWidth()
							.padding(vertical = 8.dp)
					)
				}
				items(selectedImageUrlList) { uri ->
					AsyncImage(
						model = uri,
						contentDescription = "Selected Image",
						modifier = modifier.fillMaxWidth(),
						contentScale = ContentScale.Crop
					)
					HorizontalDivider(
						modifier = modifier
							.fillMaxWidth()
							.padding(vertical = 8.dp)
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun MyImageScreenPrev() {
	MyImageScreen()
}