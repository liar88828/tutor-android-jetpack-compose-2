package com.tutor.tutor_jetpack_compose.apps.instagram

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.apps.instagram.ProfilePost.ProfilePost

@Preview
@Composable
private fun MyScreenPrev() {
	MyInstagram()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInstagram(modifier: Modifier = Modifier) {
	Scaffold(
		topBar = {
			TopAppBar(
				modifier = modifier.padding(horizontal = 16.dp),
				navigationIcon = {
					Icon(
						imageVector = Icons.AutoMirrored.Filled.ArrowBack,
						contentDescription = "Back Icon"
					)
				},
				title = {
					Text(
						modifier = Modifier.padding(start = 16.dp),
						text = "Instagram",
						fontSize = MaterialTheme.typography.titleLarge.fontSize,
						fontWeight = FontWeight.Normal
					)
				},
				actions = {
					Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
						Icon(
							imageVector = Icons.Outlined.Notifications,
							contentDescription = "Bell Notification",
							modifier.size(32.dp)
						)
						Icon(
							imageVector = Icons.Outlined.MoreVert,
							contentDescription = "Bell More",
							modifier.size(32.dp)
						)
					}
				}
			)
		},
		bottomBar = { },
		content = {
			ProfileContent(modifier = Modifier.padding(it))
		})

}

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
//	val isScrolled = remember { mutableIntStateOf(0) }
//	val removeHead by remember {
//		derivedStateOf {
//			isScrolled.intValue <= 10
//		}
//	}
//	val removeBody by remember {
//		derivedStateOf {
//			isScrolled.intValue <= 20
//		}
//	}
	val scrollState = rememberLazyGridState()
	var scrollOffset by remember { mutableIntStateOf(0) }
	val removeAction by remember {
		derivedStateOf {
			scrollOffset <= 5
		}
	}
	LaunchedEffect(scrollState) {
		snapshotFlow { scrollState.firstVisibleItemScrollOffset }
			.collect { scrollOffset = it }
	}

	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(16.dp),
		verticalArrangement = Arrangement.spacedBy(2.dp)
	) {
		AnimatedVisibility(
			visible = removeAction,
			exit = slideOutVertically() + fadeOut(),
			enter = slideInHorizontally()
		) {
			Column {
				ProfileHead()
				ProfileBody()
				ProfileAction()
				ProfileActivity()
			}
		}


		ProfilePost(scrollState)
	}
}
