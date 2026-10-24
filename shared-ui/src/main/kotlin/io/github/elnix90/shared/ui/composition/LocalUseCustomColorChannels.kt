package io.github.elnix90.shared.ui.composition

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Whether app object colors use the custom color channels from [io.github.elnix90.shared.theme.AppObjectsColors].
 *
 * Defaults to `true`. Consumers can override it (for example to fall back
 * to the default Material color channels) by providing their own value.
 */
public val LocalUseCustomColorChannels: ProvidableCompositionLocal<Boolean> = staticCompositionLocalOf { true }
