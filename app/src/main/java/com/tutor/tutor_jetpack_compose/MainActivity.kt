package com.tutor.tutor_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.ui.theme.TutorjetpackcomposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			TutorjetpackcomposeTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Greeting(
						name = "Android",
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}

@Composable
fun MyState(modifier: Modifier = Modifier) {
	val count = remember {
		mutableIntStateOf(0)
	}
	val multipleCount = remember {
		mutableStateOf(0)
	}

	fun increment() {
		count.intValue++
	}

	fun multipleIncrement() {
		count.intValue += multipleCount.value
	}

	fun decrement() {
		if (count.intValue > 0) {
			count.intValue--
		}
	}

	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TextField(
			value = multipleCount.value.toString(),
			onValueChange = { multipleCount.value = it.toInt() })
		Button(onClick = { decrement() }) {
			Text(text = "Click Decrement ")
		}

		Text(text = count.intValue.toString())

		Button(onClick = { increment() }) {
			Text(text = "Click Increment ")
		}
		Button(onClick = { multipleIncrement() }) {
			Text(text = "Click Increment ${multipleCount.value}")
		}
	}
}

@Preview(showBackground = true, name = "MyState")
@Composable
private fun MyStatePrev() {
	MyState()
}

@Composable
fun MyButtonStyle(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp, 60.dp),
		verticalArrangement = Arrangement.spacedBy(20.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(
			shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp), onClick = { /*TODO*/ },
		) { Text(text = "Rounded corner button") }


		Button(
			shape = CutCornerShape(topStart = 10.dp, bottomEnd = 10.dp), onClick = { /*TODO*/ },
		) { Text(text = "Cut corner button") }

		Button(
			shape = CircleShape, onClick = { /*TODO*/ },
		) {
			Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Circle")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Cut corner button")
		}


		Button(
			shape = RoundedCornerShape(10.dp),
			elevation = ButtonDefaults.buttonElevation(
				defaultElevation = 10.dp,
				pressedElevation = 6.dp
			),
			colors = ButtonDefaults.buttonColors(
				containerColor = Color.Red,
				contentColor = Color.Yellow
			),
			border = BorderStroke(8.dp, Color.Green),
			onClick = { /*TODO*/ },
		) {
			Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Circle")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Cut corner button")
		}
	}
}

@Preview(showBackground = true, name = "MyButtonStyle")
@Composable
private fun MyButtonStylePrev() {
	MyButtonStyle()
}

@Composable
fun MyButton(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(20.dp),
		verticalArrangement = Arrangement.spacedBy(25.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(onClick = { /*TODO*/ }) {
			Text(text = "Simple Button")
		}


		OutlinedButton(onClick = { /*TODO*/ }) {
			Text(text = "Outline Button")
		}

		IconButton(onClick = { /*TODO*/ }) {
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
				tint = MaterialTheme.colorScheme.primary,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
		}

		TextButton(onClick = { /*TODO*/ }) {
			Text(text = "Click Text")
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
				tint = MaterialTheme.colorScheme.primary,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
		}

		Button(onClick = { /*TODO*/ }) {
			Icon(
				imageVector = Icons.Default.AddCircle,
				contentDescription = "Add Circle",
//				tint = MaterialTheme.colorScheme.error,
				modifier = modifier.size(ButtonDefaults.IconSize)
			)
			Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
			Text(text = "Click Button")
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun MyButtonPrev() {
	MyButton()
}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
	Box(
		modifier = modifier
			.background(MaterialTheme.colorScheme.primary)
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Box(
			modifier = modifier
				.background(MaterialTheme.colorScheme.secondary)
				.width(250.dp)
				.height(250.dp),
			contentAlignment = Alignment.BottomEnd
		) {
			Box(
				modifier = modifier
					.background(MaterialTheme.colorScheme.tertiary)
//					.width(100.dp)
					.height(100.dp)
			) {
				Text(text = "Subscribe please", fontSize = 28.sp)
			}
		}
	}
}

@Preview(showBackground = true, name = "MyBox")
@Composable
private fun MyBoxPrev() {
	MyBox()
}

@Composable
fun FirstApp(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier
			.height(250.dp)
			.width(350.dp),
		shape = RoundedCornerShape(25.dp),
		color = MaterialTheme.colorScheme.primary,
		border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.error)
	) {
		Column(
			modifier = modifier.padding(16.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceAround
		) {
			TestComp(text = "Hello ")
			TestComp(text = "Hello World")
			TestComp(text = "Hello World twice")
		}
	}
}

@Composable
fun TestComp(modifier: Modifier = Modifier, text: String) {
	Text(
		text = text, fontSize = 32.sp,
		style = MaterialTheme.typography.bodyLarge,
		fontStyle = FontStyle.Italic
	)
	HorizontalDivider()
}

@Preview(showBackground = true, name = "FirstApp")
@Composable
private fun FirstAppPrev() {
	FirstApp()

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	TutorjetpackcomposeTheme {
		Greeting("Android")
	}
}