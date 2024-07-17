package com.tutor.tutor_jetpack_compose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MyScreenForm(modifier: Modifier = Modifier, navController: NavHostController) {
	val name = remember { mutableStateOf("") }
	val age = remember { mutableStateOf("") }

	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Home Screen", fontSize = 40.sp)

		Spacer(modifier = Modifier.height(10.dp))

		TextField(
			label = { Text(text = "Name") },
			placeholder = { Text(text = "Enter your name") },
			value = name.value, onValueChange = { name.value = it })

		Spacer(modifier = Modifier.height(10.dp))

		TextField(
			label = { Text(text = "Age") },
			placeholder = { Text(text = "Enter your age") },
			value = age.value, onValueChange = { age.value = it },
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
		)

		Button(onClick = {
//			navController.navigate("ScreenBio?name=${name.value}&age=${age.value}") {
			navController.navigate("ScreenBio/${name.value}/${age.value}")
		}) {
			Text(text = "Submit")
		}
	}
}

@Composable
fun MyScreenBio(
	modifier: Modifier = Modifier,
	name: String,
	age: Int,
	navController: NavHostController
) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Bio Screen", fontSize = 40.sp)
		Spacer(modifier = Modifier.height(10.dp))

		Text(text = "My name is $name")

		Spacer(modifier = Modifier.height(10.dp))

		Text(text = "My age is $age")

		Button(onClick = { navController.navigate("ScreenForm") }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun MyNavArgument(navController: NavHostController) {
	NavHost(navController = navController, startDestination = "ScreenForm") {
		composable("ScreenForm") { MyScreenForm(navController = navController) }
		composable(
			route = "ScreenBio/{name}/{age}",
			arguments = listOf(
				navArgument("name") { type = NavType.StringType },
				navArgument("age") { type = NavType.IntType },
			)
		) { backStackEntry ->
//			val name = it.arguments?.getString("name")
//			val age = it.arguments?.getInt("age")
			MyScreenBio(
				navController = navController,
				name = backStackEntry.arguments?.getString("name") ?: "",
				age = backStackEntry.arguments?.getInt("age") ?: 0,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun MyScreenPrev(modifier: Modifier = Modifier) {
	val navController = rememberNavController()

	Surface(
		modifier = modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		MyNavArgument(navController = navController)
	}
}
