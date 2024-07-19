package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val imageSlider = listOf(
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MySliderApp(modifier: Modifier = Modifier) {
	val pagerState = rememberPagerState(
		pageCount = { imageSlider.size },
		initialPage = 0
	)


	LaunchedEffect(key1 = Unit) {
		while (true) {
			delay(2000)
			val nextPage = (pagerState.currentPage + 1) % (pagerState.pageCount)
			// not animate
//			pagerState.scrollToPage(page = nextPage)
			pagerState.animateScrollToPage(
				page = nextPage,
				pageOffsetFraction = 0.1f,
			)

		}
	}
	val scope = rememberCoroutineScope()

	fun nextPageImage(
		pagerState: PagerState,
		scope: CoroutineScope
	) {
		val nextPage = pagerState.currentPage + 1
		if (nextPage < imageSlider.size) {
			scope.launch {
				pagerState.animateScrollToPage(
					page = nextPage,
				)
			}
		}
	}

	fun prevPageImage(
		pagerState: PagerState,
		scope: CoroutineScope
	) {
		val prevPage = pagerState.currentPage - 1
		if (prevPage >= 0) {
			scope.launch {
				pagerState.animateScrollToPage(page = prevPage)
			}
		}
	}

	Column(
		modifier = modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(modifier = modifier.wrapContentSize()) {
			HorizontalPager(
				state = pagerState,
				modifier = modifier
					.wrapContentSize(),
			) { currentPage ->
				Card(
					modifier = modifier
						.wrapContentSize()
						.padding(26.dp),
					elevation = CardDefaults.cardElevation(8.dp)
				) {
					Image(
						modifier = modifier
							.fillMaxWidth()
							.height(300.dp),
						contentScale = ContentScale.Crop,
						painter = painterResource(id = imageSlider[currentPage]),
						contentDescription = "Image Slider"
					)
				}
			}

			IconButton(
				modifier = modifier
					.padding(16.dp)
					.size(48.dp)
					.align(Alignment.CenterEnd)
					.clip(CircleShape),
				colors = IconButtonDefaults.iconButtonColors(
					containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
				),
				onClick = { nextPageImage(pagerState, scope) }) {
				Icon(
					imageVector = Icons.AutoMirrored.Filled.ArrowForward,
					contentDescription = "Icon Left"
				)
			}

			IconButton(
				modifier = modifier
					.padding(16.dp)
					.size(48.dp)
					.align(Alignment.CenterStart)
					.clip(CircleShape),
				colors = IconButtonDefaults.iconButtonColors(
					containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
				),
				onClick = { prevPageImage(pagerState, scope) }) {
				Icon(
					imageVector = Icons.AutoMirrored.Filled.ArrowBack,
					contentDescription = "Icon Right"
				)
			}
		}


		PageIndicator(
			pageCount = imageSlider.size, currentPage = pagerState.currentPage, modifier = modifier
		)
	}

}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
	Row(
		modifier = modifier.padding(top = 10.dp),
		horizontalArrangement = Arrangement.Center
	)
	{ repeat(pageCount) { IndicatorDot(isSelected = it == currentPage) } }
}

@Composable
fun IndicatorDot(isSelected: Boolean, modifier: Modifier = Modifier) {
	val color = if (isSelected) Color.DarkGray else Color.LightGray
	Box(
		modifier = modifier
			.padding(2.dp)
			.clip(CircleShape)
			.background(color)
			.size(10.dp)
	)
}

@Preview(showBackground = true)
@Composable
private fun MySliderAppPrev() {
	MySliderApp()
}