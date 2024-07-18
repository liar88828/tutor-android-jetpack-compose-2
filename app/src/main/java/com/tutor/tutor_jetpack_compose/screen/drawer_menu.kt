package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawMenu(modifier: Modifier = Modifier) {
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()


	ModalNavigationDrawer(
		drawerContent = {
			SlideBar(
				modifier,
				scope = scope,
				drawerState = drawerState
			)
		},
		drawerState = drawerState
	) {
		Scaffold(
			topBar = { MyTopAppBar(scope, drawerState) }
		) { paddingValues ->
			MyContent(paddingValues, scope, drawerState)
		}
	}

}

@Composable
private fun MyContent(
	paddingValues: PaddingValues,
	scope: CoroutineScope,
	drawerState: DrawerState
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.padding(paddingValues),
		contentAlignment = Alignment.Center
	) {
		Button(onClick = {
			scope.launch {
				drawerState.open()
			}
		}) {
			Text(text = "Open drawer")
		}
	}
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MyTopAppBar(
	scope: CoroutineScope,
	drawerState: DrawerState
) {
	TopAppBar(title = { Text(text = "drawer menu") },
		navigationIcon = {
			IconButton(onClick = {
				scope.launch {
					drawerState.open()
				}
			}) {
				Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu Icon")
			}
		}
	)
}

@Composable
fun SlideBar(
	modifier: Modifier = Modifier,
	scope: CoroutineScope,
	drawerState: DrawerState,
) {
	ModalDrawerSheet {
		Column(
			modifier = modifier.fillMaxSize(),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			Column {
				SlideBarProfile(modifier)
				HorizontalDivider(modifier = modifier.height(2.dp), color = Color.DarkGray)
				Spacer(modifier = modifier.height(5.dp))
				SlideBarList(
					itemsData = slideBarItems,
					scope = scope,
					drawerState = drawerState,
				)
				HorizontalDivider(modifier = modifier.height(2.dp), color = Color.DarkGray)
				SlideBarList(
					itemsData = slideBarItems2,
					scope = scope,
					drawerState = drawerState,
				)
			}
		}
	}
}

@Composable
private fun SlideBarProfile(modifier: Modifier) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.height(200.dp)
			.background(Color.LightGray),
		contentAlignment = Alignment.Center
	) {
		Column(
			modifier = modifier
				.wrapContentSize()
				.padding(10.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Image(
				modifier = modifier
					.height(100.dp)
					.clip(CircleShape),
				painter = painterResource(id = R.drawable.ic_launcher_background),
				contentDescription = "Image",
				contentScale = ContentScale.Crop,
			)
			Spacer(modifier = modifier.height(10.dp))
			Text(
				text = "Hello",
				modifier = modifier
					.fillMaxWidth(),
				fontSize = MaterialTheme.typography.headlineLarge.fontSize,
				textAlign = TextAlign.Center
			)
		}
	}
}

@Composable
private fun SlideBarList(
	modifier: Modifier = Modifier,
	itemsData: List<SlideBarItem>,
	scope: CoroutineScope,
	drawerState: DrawerState,
) {
	var selectItem by remember {
		mutableStateOf(slideBarItems[0])
	}

	itemsData.forEach {
		NavigationDrawerItem(
			modifier = modifier.padding(horizontal = 20.dp),
			label = { Text(text = it.text) },
			selected = it == selectItem,
			onClick = {
				selectItem = it
				scope.launch {
					drawerState.close()
				}
			},
			icon = { Icon(imageVector = it.icon, contentDescription = it.text) },
			badge = {
				if (it.badge > 0) {
					BadgedBox(badge = {
						Badge(
							modifier = modifier
								.padding(end = 10.dp)
						) {
							Text(text = it.badge.toString(), fontSize = 17.sp)
						}
					}) {
						Box(
						) {
							Icon(
								imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
								contentDescription = it.text,
								tint = Color.Transparent
							)
						}
					}
				}
			}
		)
	}

}

@Composable
private fun OldSlideBarListItem(modifier: Modifier) {
	LazyColumn(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp),
		contentPadding = PaddingValues(5.dp),
		verticalArrangement = Arrangement.spacedBy(5.dp)
	) {
//		items(slideBarItems) {
//			SlideBarListItem(item = it)
//		}
	}
}

@Composable
private fun BadgeIndicator(it: SlideBarItem) {
	BadgedBox(badge = {
		Badge {
			Text(text = it.badge.toString(), fontSize = 17.sp)
		}
	}) {
		Icon(imageVector = it.icon, contentDescription = it.text)
	}
}

@Composable
private fun SlideBarListItem(
	modifier: Modifier = Modifier,
	item: SlideBarItem
) {
	Button(
		modifier = modifier.fillMaxWidth(),
		colors = ButtonDefaults.buttonColors(
			containerColor = Color.Gray,
		),
		onClick = { /*TODO*/ }) {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(5.dp),
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(imageVector = item.icon, contentDescription = item.text)
			Spacer(modifier = modifier.width(ButtonDefaults.IconSpacing))
			Text(
				text = item.text,
				fontSize = MaterialTheme.typography.bodyLarge.fontSize,
				fontWeight = FontWeight.Bold,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun SlideBarPrev() {
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	SlideBar(
		scope = scope, drawerState = drawerState
	)
}

@Preview(showBackground = true)
@Composable
private fun DrawMenuPrev() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		DrawMenu()
	}
}

data class SlideBarItem(
	val icon: ImageVector,
	val text: String,
	val badge: Int,
)

val slideBarItems = listOf(
	SlideBarItem(
		badge = 0,
		icon = Icons.Default.ShoppingCart,
		text = "Shopping Cart"
	),
	SlideBarItem(
		badge = 864,
		icon = Icons.Default.Settings,
		text = "Setting"
	),
	SlideBarItem(
		badge = 318,
		icon = Icons.Default.ThumbUp,
		text = "Like"
	),
)
val slideBarItems2 = listOf(
	SlideBarItem(
		badge = 815,
		icon = Icons.Default.Edit,
		text = "Edit Profile"
	),
	SlideBarItem(
		badge = 0,
		icon = Icons.Default.Person,
		text = "User Cart"
	),
	SlideBarItem(
		badge = 864,
		icon = Icons.Default.Settings,
		text = "Setting"
	),
)
