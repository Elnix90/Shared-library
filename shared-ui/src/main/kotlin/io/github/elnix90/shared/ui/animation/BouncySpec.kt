package io.github.elnix90.shared.ui.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring

/**
 * A spring spec with a medium bouncy damping ratio and low stiffness.
 */
public fun <T> bouncySpec(): SpringSpec<T> =
	spring(
		dampingRatio = Spring.DampingRatioMediumBouncy,
		stiffness = Spring.StiffnessLow
	)
