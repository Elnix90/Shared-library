package io.github.elnix90.shared.ui.dragon.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.github.elnix90.shared.theme.AppObjectsColors
import io.github.elnix90.shared.ui.base.remember.rememberInteractionSource
import io.github.elnix90.shared.ui.base.withHaptic
import io.github.elnix90.shared.ui.dragon.dialogs.UserValidation

@Composable
public fun DragonButton(
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	enabled: Boolean = true,
	needConfirm: Boolean = false,
	confirmText: String = "Are you sure?",
	isCancel: Boolean = false,
	interactionSource: MutableInteractionSource = rememberInteractionSource(),
	content: @Composable RowScope.() -> Unit
) {
	var showConfirmPopup by remember { mutableStateOf(false) }

	val colors = if (isCancel) AppObjectsColors.cancelButtonColors() else AppObjectsColors.buttonColors()
	Button(
		modifier = modifier,
		onClick =
			withHaptic {
				if (needConfirm) {
					showConfirmPopup = true
				} else {
					onClick()
				}
			},
		shapes = ButtonDefaults.shapes(),
		enabled = enabled,
		colors = colors,
		interactionSource = interactionSource,
		content = content
	)

	if (showConfirmPopup) {
		UserValidation(
			message = confirmText,
			onDismiss = { showConfirmPopup = false }
		) {
			onClick()
			showConfirmPopup = false
		}
	}
}

@Composable
public fun DragonGroupScope.DragonButton(
	onClick: () -> Unit,
	enabled: Boolean = true,
	needConfirm: Boolean = false,
	confirmText: String = "Are you sure?",
	isCancel: Boolean = false,
	content: @Composable RowScope.() -> Unit
) {
	DragonButton(
		onClick = onClick,
		modifier = Modifier.dragonSettingGroup(enabled = enabled),
		enabled = enabled,
		needConfirm = needConfirm,
		confirmText = confirmText,
		isCancel = isCancel,
		content = content
	)
}
