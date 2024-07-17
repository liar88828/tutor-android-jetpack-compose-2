package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val navigationItems = listOf(
	NavigationState(
		title = "Home",
		select = Icons.Default.Home,
		unSelect = Icons.Outlined.Home,
		hasBadge = false,
		badgeCount = 0
	),
	NavigationState(
		title = "Search",
		select = Icons.Default.Search,
		unSelect = Icons.Outlined.Search,
		hasBadge = false,
		badgeCount = 1
	),
	NavigationState(
		title = "Settings",
		select = Icons.Default.Settings,
		unSelect = Icons.Outlined.Settings,
		hasBadge = false,
		badgeCount = 2
	),
	NavigationState(
		title = "Profile",
		select = Icons.Default.Person,
		unSelect = Icons.Outlined.Person,
		hasBadge = false,
		badgeCount = 3
	),
)

data class NavigationState(
	val title: String,
	val select: ImageVector,
	val unSelect: ImageVector,
	val hasBadge: Boolean,
	val badgeCount: Int,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(modifier: Modifier = Modifier) {
	val bottomNavigation = rememberSaveable { mutableIntStateOf(0) }

	Scaffold(
		topBar = { TopAppBar(title = { Text(text = "Top Bar") }) },
		bottomBar = { BottomNavigationBar(bottomNavigation) },
		floatingActionButton = { FloatingActionButtonBar() },
	) { paddingValues -> MainScreen(paddingValues, bottomNavigation) }
}

@Composable
private fun MainScreen(
	paddingValues: PaddingValues,
	bottomNavigation: MutableIntState
) {
	Column(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = navigationItems[bottomNavigation.intValue].title,
			fontSize = 30.sp,
			fontWeight = FontWeight.Bold
		)
	}
}

@Composable
private fun FloatingActionButtonBar() {
	FloatingActionButton(onClick = { /*TODO*/ }) {
		Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
	}
}

@Composable
private fun BottomNavigationBar(bottomNavigation: MutableIntState) {
	NavigationBar(
		modifier = Modifier
			.padding(10.dp)
			.clip(RoundedCornerShape(20.dp)),
		containerColor = MaterialTheme.colorScheme.background,
	) {
		navigationItems.forEachIndexed { index, item ->
			NavigationBarItem(
				selected = index == bottomNavigation.intValue,
				onClick = { bottomNavigation.intValue = index },
				label = { Text(text = item.title) },
				colors = NavigationBarItemDefaults.colors(
					selectedIconColor = Color.Red,
					selectedTextColor = Color.Green,
					indicatorColor = Color.Blue,
				),
				icon = {
					BadgedBox(badge = {
						if (item.hasBadge) Badge {}
						if (item.badgeCount != 0) Badge {
							Text(text = item.badgeCount.toString())
						}
					}) {
						Column(
							horizontalAlignment = Alignment.CenterHorizontally,
						) {
							Icon(imageVector = item.select, contentDescription = item.title)
//							Text(
//								text = item.title,
//								fontSize = 10.sp,
//								fontWeight = FontWeight.Bold
//							)
						}
					}
				})
		}
	}
}

@Preview
@Composable
private fun MyScaffoldPrev() {
	MyScaffold()
}

