package com.ts0ra.minecraft

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ts0ra.minecraft.ui.navigation.MinecraftAppNavigation
import com.ts0ra.minecraft.ui.theme.MinecraftTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinecraftApp() {
    MinecraftAppNavigation()
}



@Preview(showBackground = true)
@Composable
fun MinecraftAppPreview() {
    MinecraftTheme {
        MinecraftApp()
    }
}