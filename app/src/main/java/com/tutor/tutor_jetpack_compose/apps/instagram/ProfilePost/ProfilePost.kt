package com.tutor.tutor_jetpack_compose.apps.instagram.ProfilePost

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.swipe.TabItem

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun ProfilePost(
	scrollState: LazyGridState, modifier: Modifier = Modifier
) {
	var selectedTabIndex by remember { mutableIntStateOf(0) }
	val pagerState = rememberPagerState { tabItems.size }

	LaunchedEffect(selectedTabIndex) {
		pagerState.animateScrollToPage(selectedTabIndex)
	}

	LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
		if (!pagerState.isScrollInProgress) {
			selectedTabIndex = pagerState.currentPage
		}
	}


	TabRow(
		selectedTabIndex = selectedTabIndex,
	) {
		tabItems.forEachIndexed { index, item ->
			Tab(
				selected = selectedTabIndex == index,
				modifier = Modifier.padding(10.dp),
				onClick = { selectedTabIndex = index }) {
				Icon(
					modifier = Modifier.size(22.dp),
					imageVector = if (selectedTabIndex == index) item.selectIcon else item.unSelectIcon,
					contentDescription = item.title
				)
			}
		}
	}
	HorizontalPager(
		state = pagerState,
	) { page ->
		when (page) {
			0 -> ProfileGalleryPost(scrollState)
			1 -> Box(
				modifier = Modifier.fillMaxSize(),
				contentAlignment = Alignment.Center,
			) {
				Text(
					text = "screen 2"
				)
			}

			2 -> Box(
				modifier = Modifier.fillMaxSize(),
				contentAlignment = Alignment.Center
			) {
				Text(
					text = "screen 3"
				)
			}
		}
	}
}

val tabItems = listOf(
	TabItem(
		selectIcon = Icons.Default.Menu,
		unSelectIcon = Icons.Outlined.Menu,
		title = "Menu",
	),
	TabItem(
		selectIcon = Icons.Default.Lock,
		unSelectIcon = Icons.Outlined.Lock,
		title = "Profile",
	),
	TabItem(
		selectIcon = Icons.Default.ThumbUp,
		unSelectIcon = Icons.Outlined.ThumbUp,
		title = "Like",
	),
)
