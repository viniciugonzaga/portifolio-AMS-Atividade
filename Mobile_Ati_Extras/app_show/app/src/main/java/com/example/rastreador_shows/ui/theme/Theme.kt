package com.example.rastreador_shows.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.darkColorScheme


private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,
    background = DarkBackground,
    surface = SurfaceDark,
    onPrimary = TextLight,
    onBackground = TextLight,
    onSurface = TextLight
)

@Composable
fun Rastreador_ShowsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}