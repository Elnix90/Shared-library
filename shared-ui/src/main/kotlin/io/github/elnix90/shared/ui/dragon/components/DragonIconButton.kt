package io.github.elnix90.shared.ui.dragon.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import io.github.elnix90.shared.theme.AppObjectsColors
import io.github.elnix90.shared.ui.base.remember.rememberInteractionSource

@Composable
private fun DragonIconButtonImpl(
	onClick: () -> Unit,
	modifier: Modifier,
	enabled: Boolean,
	interactionSource: MutableInteractionSource,
	colors: IconButtonColors,
	content: @Composable () -> Unit
) {
	IconButton(
		onClick = onClick,
		modifier = modifier,
		enabled = enabled,
		colors = colors,
		interactionSource = interactionSource,
		shapes = IconButtonDefaults.shapes(),
		content = content
	)
}

@Composable
public fun DragonIconButton(
	@DrawableRes icon: Int,
	contentDescription: Int,
	modifier: Modifier = Modifier,
	enabled: Boolean = true,
	isCancel: Boolean = false,
	interactionSource: MutableInteractionSource = rememberInteractionSource(),
	onClick: () -> Unit
) {
	val colors = if (isCancel) AppObjectsColors.cancelIconButtonColors() else AppObjectsColors.iconButtonColors()

	DragonTooltip(contentDescription) {
		DragonIconButtonImpl(
			onClick = onClick,
			modifier = modifier,
			enabled = enabled,
			interactionSource = interactionSource,
			colors = colors
		) {
			Icon(
				painter = painterResource(icon),
				contentDescription = stringResource(contentDescription)
			)
		}
	}
}

@Composable
public fun DragonIconButton(
	@DrawableRes icon: Int,
	contentDescription: String,
	modifier: Modifier = Modifier,
	enabled: Boolean = true,
	isCancel: Boolean = false,
	interactionSource: MutableInteractionSource = rememberInteractionSource(),
	onClick: () -> Unit
) {
	val colors = if (isCancel) AppObjectsColors.cancelIconButtonColors() else AppObjectsColors.iconButtonColors()

	DragonTooltip(contentDescription) {
		DragonIconButtonImpl(
			onClick = onClick,
			modifier = modifier,
			enabled = enabled,
			interactionSource = interactionSource,
			colors = colors
		) {
			Icon(
				painter = painterResource(icon),
				contentDescription = contentDescription
			)
		}
	}
}
