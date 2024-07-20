package com.tutor.tutor_jetpack_compose.apps.instagram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileBody() {
	Column(
		verticalArrangement = Arrangement.spacedBy(2.dp)
	) {
		ProfileBodyTitle(
			name = "Febrian Alif Hermawan",
			nickname = "Programing mentor"
		)
		ProfileBodyCategory()
		ProfileBodyWork()
		ProfileBodyAbout()
		ProfileBodyChannel()
		ProfileBodyFollows()
	}
}

@Composable
private fun ProfileBodyTitle(
	name: String,
	nickname: String = ""
) {
	Row(
		horizontalArrangement = Arrangement.spacedBy(4.dp),
	) {
		BodyTitle(name)
		if (nickname.isNotEmpty()) {
			BodyTitle("|")
			BodyTitle(nickname)
		}
	}
}

@Composable
private fun BodyTitle(text: String) {
	Text(
		text = text,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileBodyChannel(modifier: Modifier = Modifier) {
	FlowRow(
		modifier = modifier
			.wrapContentSize()
			.wrapContentWidth(),
	) {
		ChannelTextLink("@FebrianHermawan")
		ChannelTextLink("www.instagram.com/febrianhermawan")
	}
}

@Composable
private fun ChannelTextLink(to: String) {
	ClickableText(
		text = AnnotatedString(to),
		onClick = {},
		style = TextStyle(color = Color.Blue.copy(0.5f))
	)
}

@Composable
fun ProfileBodyFollows() {
	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.spacedBy(4.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = "Followed by",
			fontWeight = FontWeight.Medium,
			fontSize = 12.sp
		)
		Text(text = "Evelyn Xu ,")
		Text(text = "Monica Erika ")
		Text(text = "and 27 other")
	}
}

@Composable
fun ProfileBodyAbout() {
	Text(text = "Lorem ipsum RitaVargas Undeliverable Diamanto, lorem Per guest prepare one jar of emeril's essence with cut sausages for dessert. ")
}

@Composable
fun ProfileBodyWork() {
	Text(
		text = "Android Developer",
		fontWeight = FontWeight.Medium,
	)
}

@Composable
fun ProfileBodyCategory() {
	Text(
		text = "Computer Science",
		fontWeight = FontWeight.Medium,
		color = Color.Gray.copy(0.9f)
	)
}

