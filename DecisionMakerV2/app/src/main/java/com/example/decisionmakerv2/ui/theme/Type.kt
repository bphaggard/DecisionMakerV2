package com.example.decisionmakerv2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.decisionmakerv2.R

val workSansFamily = FontFamily(
    Font(R.font.worksans_black, FontWeight.Black),
    Font(R.font.worksans_bold, FontWeight.Bold),
    Font(R.font.worksans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.worksans_light, FontWeight.Light),
    Font(R.font.worksans_medium, FontWeight.Medium),
    Font(R.font.worksans_regular, FontWeight.Normal),
    Font(R.font.worksans_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)