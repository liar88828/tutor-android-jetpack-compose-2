package com.tutor.tutor_jetpack_compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R

val imageId = arrayOf(
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground,
	R.drawable.ic_launcher_background,
	R.drawable.ic_launcher_foreground
)
val names = arrayOf(
	"Peperoni",
	"Vegan",
	"FourCheese",
	"Margaritta",
	"American",
	"Mexican"
)
val ingredients = arrayOf(
	"Tomato sos, cheese, oregano, peperoni",
	"Tomato sos, cheese, oregano, spinach, green paprika, rukola",
	"Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
	"Tomato sos, cheese, oregano, bazillion",
	"Tomato sos, cheese, oregano, green paprika, red beans",
	"Tomato sos, cheese, oregano, corn, jalapeno, chicken"
)

data class PizzaItem(
	val imageId: Int,
	val name: String,
	val ingredients: String
)

val pizzaItems = imageId.indices.map { index ->
	PizzaItem(
		imageId = imageId[index],
		name = names[index],
		ingredients = ingredients[index]
	)
}

@Composable
fun MyPizzaItem(item: PizzaItem, modifier: Modifier) {
	Card(
		modifier = modifier
			.padding(10.dp)
			.wrapContentSize(),
		colors = CardDefaults.cardColors(containerColor = Color.White),
		elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
	) {
		Row(
			modifier = modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Image(
				painter = painterResource(id = item.imageId),
				contentDescription = item.name,
				modifier = modifier.size(140.dp)
			)
			Column(modifier = modifier.padding(10.dp)) {
				Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
				Text(text = item.ingredients, fontWeight = FontWeight.Bold, fontSize = 18.sp)
			}
		}
	}
}

@Composable
fun MyImagePizza(modifier: Modifier = Modifier) {
	LazyColumn(contentPadding = PaddingValues(16.dp)) {
		items(pizzaItems) {
			MyPizzaItem(item = it, modifier = modifier)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun MyImageListPrev() {
	MyImagePizza()
}