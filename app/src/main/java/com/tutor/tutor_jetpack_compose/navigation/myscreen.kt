package com.tutor.tutor_jetpack_compose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun MyScreen() {
	val navController = rememberNavController()

	MyNav(navController = navController)
}

@Composable
fun MyNav(modifier: Modifier = Modifier, navController: NavHostController) {
	NavHost(navController = navController, startDestination = "screenA") {
		composable("screenA") { ScreenA(navController = navController) }
		composable("screenB") { ScreenB(navController = navController) }
		composable("screenC") { ScreenC(navController = navController) }
	}

}

@Composable
fun ScreenA(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Screen A", fontSize = 64.sp)
		Spacer(modifier = modifier.height(65.dp))
		Button(onClick = {
			navController.navigate("screenB") {
//Will fast go screen/not animation
				popUpTo("screenB") {
					inclusive = true
				}
			}
		}) {
			Text(text = "Goto Screen B", fontSize = 40.sp)
		}
	}
}

@Composable
fun ScreenB(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Screen B", fontSize = 64.sp)
		Spacer(modifier = modifier.height(65.dp))
		Button(onClick = {
			navController.navigate("screenC") {
//			popUpTo("screenC") {
//				inclusive = true
//			}
			}
		}) {
			Text(text = "Goto Screen C", fontSize = 40.sp)
		}
	}
}

@Composable
fun ScreenC(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Screen C", fontSize = 64.sp)
		Spacer(modifier = modifier.height(65.dp))
		Button(onClick = {
			navController.navigate("ScreenA") {
//			popUpTo("ScreenA") {
//				inclusive = true
//			}
			}
		}) {
			Text(text = "Goto Screen A", fontSize = 40.sp)
		}
	}
}