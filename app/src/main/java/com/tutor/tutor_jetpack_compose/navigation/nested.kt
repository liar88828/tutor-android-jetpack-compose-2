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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
private fun ShoppingScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Shopping")
		Button(onClick = { navController.navigateUp() }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun ProfileScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Profile")
		Button(onClick = { navController.navigateUp() }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun HomeScreen(
	modifier: Modifier = Modifier,
	navController: NavHostController
) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Home Screen", fontSize = 40.sp)

		Button(onClick = { navController.navigate("shopping") }) {
			Text(text = "Shopping")
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(onClick = { navController.navigate("profile") }) {
			Text(text = "profile")
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(onClick = { navController.navigate(ScreenNav.RouteSecure.route) }) {
			Text(text = "go Auth")
		}
	}
}

@Composable
private fun LoginScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Login")
		Button(onClick = { navController.navigateUp() }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun ForgetPasswordScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Forget Password")
		Button(onClick = { navController.navigateUp() }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun RegisterScreen(modifier: Modifier = Modifier, navController: NavHostController) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Register")
		Spacer(modifier = modifier.height(16.dp))
		Button(onClick = { navController.navigateUp() }) {
			Text(text = "Back")
		}
	}
}

@Composable
private fun AuthScreen(
	modifier: Modifier = Modifier,
	navController: NavHostController
) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = "Secure Screen", fontSize = 40.sp)

		Button(onClick = { navController.navigate(ScreenNav.RouteApp.route) }) {
			Text(text = "Login to home")
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(onClick = { navController.navigate("forget_password") }) {
			Text(text = "Forget Password")
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(onClick = { navController.navigate("register") }) {
			Text(text = "Register")
		}
	}
}

@Composable
private fun MyNavigation() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = ScreenNav.RouteSecure.route
	) {
		navSecureGraph(navController)
		navAppGraph(navController)
	}
}

private fun NavGraphBuilder.navAppGraph(navController: NavHostController) {
	navigation(
		startDestination = ScreenNav.RouteHome.route,
		route = ScreenNav.RouteApp.route
	) {
		composable(ScreenNav.RouteHome.route) { HomeScreen(navController = navController) }
		composable(ScreenNav.RouteShopping.route) { ShoppingScreen(navController = navController) }
		composable(ScreenNav.RouteProfile.route) { ProfileScreen(navController = navController) }
	}
}

private fun NavGraphBuilder.navSecureGraph(navController: NavHostController) {
	navigation(
		startDestination = ScreenNav.RouteAuth.route,
		route = ScreenNav.RouteSecure.route
	) {
		composable(ScreenNav.RouteAuth.route) { AuthScreen(navController = navController) }
		composable(ScreenNav.RouteLogin.route) { LoginScreen(navController = navController) }
		composable(ScreenNav.RouteForgetPassword.route) { ForgetPasswordScreen(navController = navController) }
		composable(ScreenNav.RouteRegister.route) { RegisterScreen(navController = navController) }
	}
}

@Preview(showBackground = true)
@Composable
private fun MyNavigationPrev() {
	MyNavigation()

}

// make type in route
private sealed class ScreenNav(val route: String) {
	object RouteLogin : ScreenNav(route = "login")
	object RouteRegister : ScreenNav(route = "register")
	object RouteForgetPassword : ScreenNav(route = "forget_password")
	object RouteAuth : ScreenNav(route = "auth")

	//
	object RouteHome : ScreenNav(route = "home")
	object RouteShopping : ScreenNav(route = "shopping")
	object RouteProfile : ScreenNav(route = "profile")

	//
	object RouteSecure : ScreenNav(route = "secure")
	object RouteApp : ScreenNav(route = "app")

}