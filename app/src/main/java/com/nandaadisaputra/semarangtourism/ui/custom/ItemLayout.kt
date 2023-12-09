package com.nandaadisaputra.semarangtourism.ui.custom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nandaadisaputra.semarangtourism.ui.theme.SemarangTourismTheme
import com.nandaadisaputra.semarangtourism.ui.theme.orangeRed

@Composable
fun ItemLayout(
    title: String,
    photoUrl: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        Column {
            AsyncImage(
                model = photoUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .height(150.dp)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = orangeRed,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            end = 8.dp,
                            start = 8.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemTourismPreview() {
    SemarangTourismTheme {
        ItemLayout(
            photoUrl = "https://asset.kompas.com/crops/5fOXY3K4oKdIzs-F7qNcs0qtt68=/0x0:1430x953/750x500/data/photo/2022/01/17/61e57605c2256.jpg",
            title = "Lawang Sewu"
        )
    }
}