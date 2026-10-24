package io.github.elnix90.shared.ui.base.animation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import io.github.elnix90.shared.ui.animation.bouncySpec

public val slideInHorizontalBouncy: EnterTransition = slideInHorizontally(bouncySpec()) { it } + fadeIn()
public val slideOutHorizontalBouncy: ExitTransition = slideOutHorizontally(bouncySpec()) { it } + fadeOut()

public val slideInVerticalBouncy: EnterTransition = slideInVertically(bouncySpec()) { it } + fadeIn()
public val slideOutVerticalBouncy: ExitTransition = slideOutVertically(bouncySpec()) { it } + fadeOut()

public val slideInVerticalBouncyUp: EnterTransition = slideInVertically(bouncySpec()) { -it } + fadeIn()
public val slideOutVerticalBouncyUp: ExitTransition = slideOutVertically(bouncySpec()) { -it } + fadeOut()
