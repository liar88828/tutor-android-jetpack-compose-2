package com.tutor.tutor_jetpack_compose.multiple_screen_support

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.tutor_jetpack_compose.R

@Composable
fun PortraitScreen(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState())
	) {
		Box(
			modifier = modifier
				.fillMaxWidth()
				.padding(16.dp),
			contentAlignment = Alignment.Center
		) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_background),
				contentDescription = null
			)
		}
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(16.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(text = "Hello, Android")
			Text(text = "I Text")
			Text(text = "I use for read")
		}
	}

}

@Composable
fun LandscapeScreen(modifier: Modifier = Modifier) {
	Row(
		modifier
			.fillMaxSize()
			.padding(start = 16.dp)
	) {
		Box(
			modifier = modifier
				.fillMaxHeight()
				.padding(16.dp), contentAlignment = Alignment.Center
		) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "",
				modifier = modifier.size(400.dp)
			)
		}
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			PersonalData("Name", "MkrDeveloper")
			PersonalData("Email", "john.mckinley@examplepetstore.com")
			PersonalData("Phone", "0123456789")
		}
	}
}

@Composable
fun PersonalData(title: String, content: String) {
	Column(Modifier.padding(12.dp)) {
		Text(text = title, fontWeight = FontWeight.Bold)
		Text(text = content)
		Spacer(modifier = Modifier.height(6.dp))
	}
}

data class WindowSize(
	val width: WindowType,
	val height: WindowType
)

enum class WindowType {
	SMALL,
	MEDIUM,
	LARGE
}

@Composable
fun rememberWindowSize(modifier: Modifier = Modifier): WindowSize {
	val configuration = LocalConfiguration.current
	return WindowSize(
		width = when {
			configuration.screenWidthDp < 600 -> WindowType.SMALL
			configuration.screenWidthDp < 840 -> WindowType.MEDIUM
			else -> WindowType.LARGE
		},
		height = when {
			configuration.screenHeightDp < 480 -> WindowType.SMALL
			configuration.screenHeightDp < 900 -> WindowType.MEDIUM
			else -> WindowType.LARGE
		}
	)

}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
	val windowSize = rememberWindowSize()
	when (windowSize.width) {
		WindowType.SMALL -> PortraitScreen()
		WindowType.MEDIUM -> LandscapeScreen()
		WindowType.LARGE -> LandscapeScreen()
	}
}

@Preview(showBackground = true)
@Composable
private fun LandscapeScreenPrev() {
	LandscapeScreen()

}

@Preview(showBackground = true)
@Composable
private fun PortraitScreenPrev() {
	PortraitScreen()

}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPrev() {
	ProfileScreen()
}

