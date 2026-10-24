package io.github.elnix90.shared.ui.dragon.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import io.github.elnix90.shared.R
import io.github.elnix90.shared.theme.AppObjectsColors
import io.github.elnix90.shared.ui.base.components.Spacer
import io.github.elnix90.shared.ui.dragon.components.ValidateCancelButtons
import io.github.elnix90.shared.ui.dragon.text.DialogDescription
import io.github.elnix90.shared.ui.dragon.text.DialogTitle

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
public fun UserValidation(
	title: String? = null,
	message: String?,
	validateText: String = "OK",
	cancelText: String = "Cancel",
	doNotRemindMeAgain: ((Boolean) -> Unit)? = null,
	titleIcon: Int = R.drawable.warning,
	titleColor: Color = MaterialTheme.colorScheme.onErrorContainer,
	titleBgColor: Color = MaterialTheme.colorScheme.errorContainer,
	properties: DialogProperties = DialogProperties(),
	onDismiss: (() -> Unit)? = null,
	onValidate: () -> Unit
) {
	var doNotRemindMeAgainChecked by remember { mutableStateOf(false) }

	AlertDialog(
		onDismissRequest = onDismiss ?: onValidate,
		confirmButton = {
			ValidateCancelButtons(
				confirmText = validateText,
				cancelText = cancelText,
				onCancel = onDismiss,
				onConfirm = onValidate
			)
		},
		properties = properties,
		icon = {
			Box(
				contentAlignment = Alignment.Center,
				modifier =
					Modifier
						.size(48.dp)
						.background(
							color = titleBgColor,
							shape = MaterialShapes.Pill.toShape()
						)
			) {
				Icon(
					painterResource(titleIcon),
					contentDescription = null
				)
			}
		},
		title = {
			if (title != null) {
				DialogTitle(
					text = title,
					modifier =
						Modifier
							.fillMaxWidth()
							.padding(bottom = 4.dp)
							.clip(MaterialTheme.shapes.large)
							.background(MaterialTheme.colorScheme.surface)
							.padding(8.dp)
				)
			}
		},
		text = {
			if (message != null) {
				Column {
					DialogDescription(
						text = message,
						modifier = Modifier.padding(top = 8.dp)
					)
					if (doNotRemindMeAgain != null) {
						Spacer(15.dp)
						Row(
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.spacedBy(8.dp),
							modifier = Modifier.clip(MaterialTheme.shapes.large)
						) {
							Checkbox(
								checked = doNotRemindMeAgainChecked,
								onCheckedChange = {
									doNotRemindMeAgainChecked = !doNotRemindMeAgainChecked
									doNotRemindMeAgain(doNotRemindMeAgainChecked)
								},
								colors = AppObjectsColors.checkboxColors()
							)
							Text(
								text = "Do not remind me again",
								style = MaterialTheme.typography.bodySmall,
								color = MaterialTheme.colorScheme.onSurface,
								modifier = Modifier.padding(end = 8.dp)
							)
						}
					}
				}
			}
		},
		containerColor = MaterialTheme.colorScheme.surface,
		tonalElevation = 6.dp,
		shape = MaterialTheme.shapes.large
	)
}
