package com.tutor.tutor_jetpack_compose.floatingaction_button

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionScreen(modifier: Modifier = Modifier) {
	val itemsButton = listOf(
		MiniFloatingButton(Icons.Default.Person, "Contect"),
		MiniFloatingButton(Icons.Default.Home, "Home"),
		MiniFloatingButton(Icons.Default.ThumbUp, "Like"),
		MiniFloatingButton(Icons.Default.ThumbUp, "Setting"),
	)


	Scaffold(modifier = modifier.fillMaxSize(),
		floatingActionButton = {
			val floatAction = rememberFloatButton()




			Column(
				horizontalAlignment = Alignment.End,
			) {
				AnimatedVisibility(
					visible = floatAction.expanded,
					enter = fadeIn() + slideInVertically(initialOffsetY = { it }) + expandVertically(),
					exit = fadeOut() + slideOutVertically(targetOffsetY = { it }) + shrinkVertically(),
				) {
					LazyColumn(
						modifier = modifier.padding(bottom = 10.dp),
						verticalArrangement = Arrangement.spacedBy(10.dp),
						horizontalAlignment = Alignment.End
					) {
						items(itemsButton) { MiniFloatIcon(modifier, it) }
					}
				}

				FloatingActionButton(
					containerColor = Color.Red.copy(0.5f),
					modifier = modifier.rotate(floatAction.rotation),
					onClick = { floatAction.handlerExpand() }) {
					Icon(
						imageVector = Icons.Default.Add,
						contentDescription = "Add Icons",
					)
				}
			}
		},
		content = { Text(text = "Hello") }
	)
}

@Composable
private fun MiniFloatIcon(
	modifier: Modifier,
	it: MiniFloatingButton
) {
	val context = LocalContext.current
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Center,
	) {
		Box(
			modifier = modifier
				.border(
					width = 2.dp,
					color = Color.Red,
					shape = MaterialTheme.shapes.medium
				)
				.padding(10.dp)
		) {
			Text(it.title)
		}
		Spacer(modifier = modifier.width(10.dp))
		FloatingActionButton(
			modifier = modifier.size(45.dp),
			onClick = {
				Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
			},
			containerColor = Color.Red.copy(0.5f),
		) {
			Icon(imageVector = it.icon, contentDescription = it.title)
		}
	}
}

@Composable
private fun rememberFloatButton(): FloatButtonData {
	var expanded by remember { mutableStateOf(false) }
	val transition = updateTransition(targetState = expanded, label = "Transition")
	val rotation by transition.animateFloat(label = "Rotation") {
		if (it) 315f else 0f
	}

	fun handlerExpand() {
		expanded = !expanded
	}

	return FloatButtonData(
		handlerExpand = ::handlerExpand,
		rotation,
		expanded
	)

}

data class FloatButtonData(
	val handlerExpand: () -> Unit,
	val rotation: Float,
	var expanded: Boolean
)

@Preview
@Composable
private fun FloatingActionScreenPrev() {
	FloatingActionScreen()
}

data class MiniFloatingButton(
	val icon: ImageVector,
	val title: String
)