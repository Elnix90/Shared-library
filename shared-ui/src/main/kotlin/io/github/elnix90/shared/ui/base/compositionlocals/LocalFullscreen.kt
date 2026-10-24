package io.github.elnix90.shared.ui.base.compositionlocals

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Whether the host app is currently in fullscreen mode. Defaults to false.
 */
public val LocalFullscreen: ProvidableCompositionLocal<Boolean> = staticCompositionLocalOf { false }
