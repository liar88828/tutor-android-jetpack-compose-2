package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tutor.tutor_jetpack_compose.R

@Preview(showBackground = true)
@Composable
private fun LottieAnimationPrev() {
	LazyColumn {
		items(1) {
			Loading()
			People()
		}
	}
}

@Composable
private fun People() {
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		val loading by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
		var isPlaying by remember { mutableStateOf(true) }
		val progress by animateLottieCompositionAsState(
			composition = loading,
			isPlaying = isPlaying
		)

		LaunchedEffect(key1 = progress) {
			if (progress == 0f) {
				isPlaying = true
			}
			if (progress == 1f) {
				isPlaying = false
			}
		}
		val people by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cartoon_characters))
		LottieAnimation(
			composition = people,
//					iterations = LottieConstants.IterateForever
			modifier = Modifier
				.size(500.dp)
				.clickable {
					isPlaying = !isPlaying
				},
//					iterations = LottieConstants.IterateForever,
			progress = { progress },
		)
	}
}

@Composable
private fun Loading() {
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		val loading by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
		val isPlaying = remember {
			mutableStateOf(true)
		}
		val progress by animateLottieCompositionAsState(
			composition = loading,
			isPlaying = isPlaying.value
		)
		LaunchedEffect(key1 = progress) {
			if (progress == 0f) {
				isPlaying.value = true
			}
			if (progress == 1f) {
				isPlaying.value = false
			}
		}
		LottieAnimation(
			composition = loading,
			modifier = Modifier
				.size(500.dp)
				.clickable {
					isPlaying.value = !isPlaying.value
				},
//					iterations = LottieConstants.IterateForever,
			progress = { progress },
		)
	}
}