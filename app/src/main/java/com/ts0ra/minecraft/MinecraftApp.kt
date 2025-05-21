package com.ts0ra.minecraft

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ts0ra.minecraft.ui.theme.MinecraftTheme

@Composable
fun MinecraftApp(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Text(
            text = "Minecraft",
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MinecraftAppPreview() {
    MinecraftTheme {
        MinecraftApp()
    }
}