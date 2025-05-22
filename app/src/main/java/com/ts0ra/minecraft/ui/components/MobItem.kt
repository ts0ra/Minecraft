package com.ts0ra.minecraft.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ts0ra.minecraft.ui.theme.MinecraftTheme


@Composable
fun MobItem(
    name: String,
    imageUrl: String,
    modifier: Modifier = Modifier,
    onMobClick: () -> Unit // Added onMobClick parameter
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onMobClick() } // Use onMobClick
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "$name mob",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape),
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MobItemPreview() {
    MinecraftTheme {
        MobItem(
            "Allay",
            "",
            onMobClick = {} // Added for preview
        )
    }
}