package com.tutor.tutor_jetpack_compose.swipe

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val tabItems = listOf(
	TabItem(
		selectIcon = Icons.Default.Home,
		unSelectIcon = Icons.Outlined.Home,
		title = "Home",
	),
	TabItem(
		selectIcon = Icons.Default.Face,
		unSelectIcon = Icons.Outlined.Face,
		title = "Profile",
	),
	TabItem(
		selectIcon = Icons.Default.Favorite,
		unSelectIcon = Icons.Outlined.Favorite,
		title = "Favorite",
	),
	TabItem(
		selectIcon = Icons.Default.Home,
		unSelectIcon = Icons.Outlined.Home,
		title = "Home",
	),
	TabItem(
		selectIcon = Icons.Default.Face,
		unSelectIcon = Icons.Outlined.Face,
		title = "Profile",
	),
	TabItem(
		selectIcon = Icons.Default.Favorite,
		unSelectIcon = Icons.Outlined.Favorite,
		title = "Favorite",
	),
)

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun ScreenPrev() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		Column(modifier = Modifier.fillMaxSize()) {
			var selectedTabIndex by remember { mutableIntStateOf(2) }
			val pagerState = rememberPagerState { tabItems.size }

			LaunchedEffect(selectedTabIndex) {
				pagerState.animateScrollToPage(selectedTabIndex)
				selectedTabIndex = pagerState.currentPage
			}
			LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
				// will render default as selectedTabIndex
				if (!pagerState.isScrollInProgress) {
					selectedTabIndex = pagerState.currentPage
				}
			}
// can scroll
			ScrollableTabRow(
//fix position
//			TabRow(
				selectedTabIndex = selectedTabIndex,
			) {
				tabItems.forEachIndexed { index, item ->
					Tab(
						selectedContentColor = Color.Red,
						unselectedContentColor = Color.Gray,
						modifier = Modifier.padding(10.dp),
						selected = selectedTabIndex == index,
						onClick = { selectedTabIndex = index }) {
						Icon(
							modifier = Modifier.size(36.dp),
							imageVector = if (selectedTabIndex == index) item.selectIcon else item.unSelectIcon,
							contentDescription = null
						)
						Text(text = item.title)
					}
				}
			}

			HorizontalPager(
				modifier = Modifier.fillMaxSize(),
				state = pagerState
			) {
				Box() {
					Column(
						modifier = Modifier.fillMaxSize(),
						verticalArrangement = Arrangement.Center,
						horizontalAlignment = Alignment.CenterHorizontally
					) {
						Icon(
							modifier = Modifier.size(60.dp),
							imageVector = tabItems[it].selectIcon,
							contentDescription = null,
						)
						Text(text = tabItems[it].title, fontSize = 40.sp)
					}
				}
			}
		}
	}
}