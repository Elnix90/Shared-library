package io.github.elnix90.shared.ui.dragon.components

import androidx.compose.runtime.Composable
import io.github.elnix90.shared.R

@Composable
public fun ResetIcon(enabled: Boolean = true, onReset: () -> Unit) {
	DragonIconButton(
		icon = R.drawable.reset,
		contentDescription = "Reset",
		enabled = enabled,
		onClick = onReset
	)
}

@Composable
public fun MoreIcon(enabled: Boolean = true, onReset: () -> Unit) {
	DragonIconButton(
		icon = R.drawable.more_vert,
		contentDescription = "More",
		enabled = enabled,
		onClick = onReset
	)
}

@Composable
public fun CopyIcon(enabled: Boolean = true, onCopy: () -> Unit) {
	DragonIconButton(
		icon = R.drawable.copy,
		contentDescription = "Copy",
		enabled = enabled,
		onClick = onCopy
	)
}
