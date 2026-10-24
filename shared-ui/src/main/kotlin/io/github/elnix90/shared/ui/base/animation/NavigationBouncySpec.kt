package io.github.elnix90.shared.ui.base.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring
import androidx.compose.ui.unit.IntOffset

public val navigationBouncySpec: SpringSpec<IntOffset> = spring(Spring.DampingRatioLowBouncy, Spring.StiffnessLow)
