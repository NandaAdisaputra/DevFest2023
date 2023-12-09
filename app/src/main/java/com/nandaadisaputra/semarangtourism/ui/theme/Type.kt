package com.nandaadisaputra.semarangtourism.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.nandaadisaputra.semarangtourism.R


@Immutable
data class SemarangTourismTypography(
    val caption: TextStyle,
    val body: TextStyle,
    val title: TextStyle
)

val LocalSemarangTourismTypography = staticCompositionLocalOf {
    SemarangTourismTypography(
        caption = TextStyle.Default,
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}

val fontFamily = FontFamily(
    Font(R.font.regular, FontWeight.Normal),
    Font(R.font.medium, FontWeight.Medium),
    Font(R.font.bold, FontWeight.Bold)
)