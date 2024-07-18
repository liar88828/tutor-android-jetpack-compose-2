package com.tutor.tutor_jetpack_compose.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.tutor.tutor_jetpack_compose.R
import com.tutor.tutor_jetpack_compose.screen.PizzaItem
import com.tutor.tutor_jetpack_compose.screen.pizzaItems

val pizzaItemEmpty = PizzaItem(
	imageId = R.drawable.ic_launcher_background,
	name = "Not Found",
	ingredients = "The item is not found",
)

@Composable
private fun PizzaDetail(
	navController: NavHostController,
	modifier: Modifier = Modifier,
	name: String?,
) {
	val findPizza = pizzaItems.find { it.name == name }
		?: pizzaItemEmpty
	Box(
		modifier = modifier.fillMaxSize(),
		contentAlignment = Alignment.Center,
	) {
		Card(
			modifier
				.padding(10.dp)
				.wrapContentWidth(),
			elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
			colors = CardDefaults.cardColors(containerColor = Color.White)
		) {
			Column(
				modifier = modifier.fillMaxWidth()
			) {
				Image(
					painter = painterResource(id = findPizza.imageId),
					contentDescription = "Image Pizza",
					modifier = modifier
						.fillMaxWidth()
						.size(140.dp),
					contentScale = ContentScale.Crop
				)
				Column(
					modifier = modifier.padding(20.dp),
					verticalArrangement = Arrangement.spacedBy(20.dp)
				) {
					Text(text = findPizza.name, fontSize = 46.sp, fontWeight = FontWeight.Bold)
					Text(
						text = findPizza.ingredients,
						fontSize = 20.sp,
						fontWeight = FontWeight.Bold
					)
					Button(onClick = { navController.navigateUp() }) {
						Text(text = "Back")
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun PizzaDetailPrev() {
	val navController = rememberNavController()

	PizzaDetail(
		navController = navController,
		name = "Test"
	)
}

@Composable
private fun PizzaList(
	modifier: Modifier = Modifier,
	item: PizzaItem,
	navController: NavHostController
) {
//	MyImagePizza()
	Card(
		onClick = { navController.navigate(PizzaScreen.Detail.toParam(item.name)) },
		modifier
			.padding(10.dp)
			.wrapContentSize(),
		elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
		colors = CardDefaults.cardColors(containerColor = Color.White)
	) {
		Row(
			modifier = modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically,
		) {
			Image(
				painter = painterResource(id = item.imageId), contentDescription = "Image Pizza",
				modifier = modifier.size(140.dp)
			)
			Column(
				modifier = modifier.padding(start = 10.dp),
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Text(text = item.name, fontSize = 25.sp, fontWeight = FontWeight.Bold)
				Text(text = item.ingredients, fontSize = 16.sp, fontWeight = FontWeight.Bold)
			}
		}
	}

}

@Preview(showBackground = true)
@Composable
private fun PizzaListPrev() {
	val navController = rememberNavController()

	PizzaList(
		item = PizzaItem(
			imageId = R.drawable.ic_launcher_background,
			name = "Text",
			ingredients = "Test lorem ipsum dolor sit amet ",
		),
		navController = navController
	)
}

@Composable
fun PizzaHome(modifier: Modifier = Modifier, navController: NavHostController) {
	LazyColumn(
		contentPadding = PaddingValues(10.dp),
		modifier = modifier.fillMaxSize(),
//		horizontalAlignment = Alignment.CenterHorizontally,
//		verticalArrangement = Arrangement.Center
	) {
		items(pizzaItems) {
			PizzaList(item = it, navController = navController)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun PizzaNavPrev() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = PizzaScreen.Home.route) {
		navigation(startDestination = PizzaScreen.List.route, route = PizzaScreen.Home.route) {
			composable(PizzaScreen.List.route) { PizzaHome(navController = navController) }
			composable(
				PizzaScreen.Detail.route,
				arguments = listOf(navArgument("name") { type = NavType.StringType })
			) { navBack ->
				val name = navBack.arguments?.getString("name")
				PizzaDetail(
					navController = navController,
					name = name,
				)
			}
		}
	}
}

sealed class PizzaScreen(
	val route: String,
) {
	object Home : PizzaScreen("home")
	object List : PizzaScreen("list")
	object Detail : PizzaScreen("detail/{name}")

	fun toParam(
		name: String? = null,
		paramName: String = "name",
	): String {
		return if (name != null) {
			route.replace("{$paramName}", name)
		} else {
			route
		}
	}
}