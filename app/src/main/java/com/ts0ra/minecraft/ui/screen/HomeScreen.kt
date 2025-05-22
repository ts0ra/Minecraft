package com.ts0ra.minecraft.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ts0ra.minecraft.model.MobsData
import com.ts0ra.minecraft.ui.components.MobItem
import com.ts0ra.minecraft.ui.components.MyTopBar
import com.ts0ra.minecraft.ui.theme.MinecraftTheme

@Composable
fun HomeScreen(onMenuClick: () -> Unit, onMobClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            MyTopBar(onMenuClick = onMenuClick)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn {
                items(MobsData.mobs, key = { it.id }) { mob ->
                    MobItem(
                        name = mob.name,
                        imageUrl = mob.image,
                        modifier = Modifier.fillMaxWidth(),
                        onMobClick = { onMobClick(mob.id) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MinecraftTheme {
        HomeScreen(
            onMenuClick = {},
            onMobClick = {}
        )
    }
}
