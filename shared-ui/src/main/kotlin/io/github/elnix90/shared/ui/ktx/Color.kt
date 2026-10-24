package io.github.elnix90.shared.ui.ktx

import androidx.compose.ui.graphics.Color

/**
 * Returns a copy of this [Color] with its alpha multiplied by [multiplier].
 *
 * The RGB components remain unchanged.
 *
 * @param multiplier factor applied to the current alpha value
 * @return a copy of this color with the adjusted alpha
 */
public fun Color.alphaMultiplier(multiplier: Float): Color = copy(alpha = alpha * multiplier)

/**
 * Returns this [Color], reducing its alpha by half when [enabled] is false.
 *
 * If [enabled] is true, the color is returned unchanged.
 *
 * @param enabled whether the color should remain fully effective
 * @return this color, or a version with its alpha halved when disabled
 */
public fun Color.semiTransparentIfDisabled(enabled: Boolean): Color = if (enabled) this else alphaMultiplier(0.5f)
