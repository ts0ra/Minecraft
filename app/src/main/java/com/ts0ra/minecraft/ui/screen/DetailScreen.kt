package com.ts0ra.minecraft.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ts0ra.minecraft.model.MobsData
import com.ts0ra.minecraft.ui.theme.MinecraftTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    mobId: Int,
    onMenuClick: () -> Unit
) {
    val mob = MobsData.mobs.find { it.id == mobId }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        onMenuClick()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text("Mob Detail")
                },
            )
        }
    ) { paddingValues ->
        if (mob != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
            ) {
                AsyncImage(
                    model = mob.image,
                    contentDescription = "${mob.name} image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(140.dp)
                        .clip(CircleShape),
                )
                Text(mob.name)
                Row {
                    Text("Health: ${mob.health}")
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Text("Damage: ${mob.damage}")
                }
                Text(
                    text = mob.description,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
            ) {
                Text("Mob not found")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MinecraftTheme {
        DetailScreen(
            mobId = 1, // Use a valid mobId for preview
            onMenuClick = {}
        )
    }
}