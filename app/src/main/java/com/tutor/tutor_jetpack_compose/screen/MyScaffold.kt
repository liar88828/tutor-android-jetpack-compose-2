package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@Composable
fun MyScaffold(modifier: Modifier = Modifier) {
	val bottomNavigation = rememberSaveable { mutableIntStateOf(0) }

	Scaffold(
		topBar = { MyTopBar(bottomNavigation = bottomNavigation.intValue) },
		bottomBar = { MyBottomAppBar() },
//		bottomBar = { BottomNavigationBar(bottomNavigation) },
//		floatingActionButton = { MyFloatingActionButton() },
	) { paddingValues -> MainScreen(paddingValues, bottomNavigation.intValue) }
}

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
//	BottomNavigationBar
	BottomAppBar(
		modifier = modifier
			.padding(10.dp)
			.clip(RoundedCornerShape(20.dp)),
		containerColor = MaterialTheme.colorScheme.background,
	) {
		Row(
			modifier = modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceAround,
		) {
			IconButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.Home, contentDescription = "Icon Home")
			}
			IconButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.Email, contentDescription = "Icon Email")
			}

			MyFloatingActionButton()

			IconButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Icon")
			}
			IconButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Shopping Icon")
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTopBar(modifier: Modifier = Modifier, bottomNavigation: Int) {
	TopAppBar(
		modifier = modifier
			.padding(10.dp)
			.clip(RoundedCornerShape(20.dp)),
		title = {
			Box(
				modifier = modifier.fillMaxWidth(),
				contentAlignment = Alignment.TopStart
			) {
				Text(text = navigationItems[bottomNavigation].title)
			}
		},
		navigationIcon = {
			IconButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Default.Menu,
					contentDescription = "Menu Icon"
				)
			}
		},
		actions = {
			IconButton(onClick = { /*TODO*/ }) {
				BadgedBox(badge = {
					Badge(modifier = modifier.size(10.dp)) { Text(text = "") }
				}) {
					Icon(
						imageVector = Icons.Default.Share,
						contentDescription = "Setting Icon"
					)
				}
			}
			IconButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Default.Settings,
					contentDescription = "Setting Icon"
				)
			}
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
		)
	)
}

@Composable
private fun MainScreen(
	paddingValues: PaddingValues,
	bottomNavigation: Int
) {
	Column(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = navigationItems[bottomNavigation].title,
			fontSize = 30.sp,
			fontWeight = FontWeight.Bold
		)
	}
}

@Composable
private fun MyFloatingActionButton() {
	FloatingActionButton(
		onClick = { /*TODO*/ },
//		shape = RoundedCornerShape(
//			topStart = 25.dp,
//			topEnd = 25.dp,
//			bottomStart = 25.dp,
//			bottomEnd = 5.dp,
//		),
		shape = RoundedCornerShape(
			topStart = 10.dp,
			topEnd = 10.dp,
			bottomStart = 10.dp,
			bottomEnd = 10.dp,
		),
		containerColor = MaterialTheme.colorScheme.primary
	) {
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

