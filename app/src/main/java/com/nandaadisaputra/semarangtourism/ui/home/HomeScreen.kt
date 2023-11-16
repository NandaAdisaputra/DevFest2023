package com.nandaadisaputra.semarangtourism.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nandaadisaputra.semarangtourism.ui.theme.SemarangTourismTheme

@Composable
fun HomeScreen() {
    SemarangTourismTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically),
            color = MaterialTheme.colors.background,
        ) {
            Greeting("Home")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Ini Halaman $name!",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier
            .clickable { }
            .background(Color.White)
            .padding(8.dp)
            .border(2.dp, Color.Blue)
            .padding(8.dp),
        color = Color.Blue,

        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    SemarangTourismTheme {
        Greeting("Home")
    }
}