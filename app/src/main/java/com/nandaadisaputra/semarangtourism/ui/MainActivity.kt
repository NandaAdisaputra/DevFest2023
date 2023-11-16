package com.nandaadisaputra.semarangtourism.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nandaadisaputra.semarangtourism.SemarangTourismApp
import com.nandaadisaputra.semarangtourism.ui.theme.SemarangTourismTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemarangTourismTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundColor
                ) {
                    SemarangTourismApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SemarangTourismAppPreview() {
    SemarangTourismTheme {
        SemarangTourismApp()
    }
}
