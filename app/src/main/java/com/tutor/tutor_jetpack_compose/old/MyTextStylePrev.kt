package com.tutor.tutor_jetpack_compose.old

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.tutor_jetpack_compose.R

@Preview(showBackground = true, name = "MyTextStylePrev")
@Composable
private fun MyTextStylePrev() {
	MyTextStyle()
}

@Composable
private fun MyTextStyle(modifier: Modifier = Modifier) {
	Column {
		Text(text = buildAnnotatedString {
			withStyle(
				style = ParagraphStyle(
					textIndent = TextIndent(firstLine = 20.sp)
				)
			) {
				withStyle(style = SpanStyle(color = Color.Red, fontSize = 30.sp)) {
					append("H")
				}
				append("ello ")
				withStyle(style = SpanStyle(color = Color.Green, fontSize = 30.sp)) {
					append("W")
				}
				append("orld")
			}
			append("Variusaenean Ligulafames Lectustorquent Ligulainterdum")
		})



		Text(
			text = stringResource(id = R.string.Hello).repeat(30),
			modifier = modifier
				.background(MaterialTheme.colorScheme.error)
				.width(200.dp),
			color = MaterialTheme.colorScheme.primary,
			style = MaterialTheme.typography.bodyLarge,
			fontStyle = FontStyle.Italic,
			fontWeight = FontWeight.Bold,
			fontSize = 25.sp,
//		fontFamily = FontFamily.Cursive
			fontFamily = FontFamily(Font(R.font.poppins)),
			textDecoration = TextDecoration.LineThrough,
			textAlign = TextAlign.Justify,
			lineHeight = 40.sp,
			overflow = TextOverflow.Ellipsis,
			maxLines = 7
		)
	}

}

