package io.github.elnix90.shared.ui.base.compositionlocals

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Whether haptic feedback is disabled globally. Defaults to false (haptics enabled).
 */
public val LocalDisableHapticFeedbackGlobally: ProvidableCompositionLocal<Boolean> = staticCompositionLocalOf { false }
