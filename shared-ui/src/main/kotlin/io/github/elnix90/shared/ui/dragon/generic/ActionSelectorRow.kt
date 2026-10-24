package io.github.elnix90.shared.ui.dragon.generic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.elnix90.shared.R
import io.github.elnix90.shared.theme.AppObjectsColors
import io.github.elnix90.shared.ui.base.components.BoxedIcon
import io.github.elnix90.shared.ui.base.components.Spacer
import io.github.elnix90.shared.ui.base.remember.rememberInteractionSource
import io.github.elnix90.shared.ui.dragon.components.DragonGroupScope
import io.github.elnix90.shared.ui.dragon.components.DragonModalBottomSheet
import io.github.elnix90.shared.ui.dragon.components.DragonSettingsGroup
import io.github.elnix90.shared.ui.dragon.components.ResetIcon
import io.github.elnix90.shared.ui.dragon.text.TextWithDescription
import io.github.elnix90.shared.ui.ktx.alphaMultiplier
import io.github.elnix90.shared.ui.ktx.semiTransparentIfDisabled

@Composable
public fun <T> DragonGroupScope.ActionSelectorRow(
	options: List<T>,
	selected: T,
	switchEnabled: Boolean = true,
	label: String,
	icon: Int,
	optionLabel: @Composable (T) -> String = { it.toString() },
	optionDesc: (@Composable (T) -> String)? = null,
	toggled: Boolean? = null,
	enabled: Boolean = true,
	resetEnabled: Boolean,
	onReset: () -> Unit,
	onSelected: (T?) -> Unit
) {
	var showSheet by remember { mutableStateOf(false) }

	val switchInteractionSource = rememberInteractionSource()
	val globalInteractionSource = rememberInteractionSource()

	Row(
		modifier =
			Modifier
				.dragonSettingGroup(enabled) {
					clickable(
						enabled = enabled,
						interactionSource = if (toggled == true) globalInteractionSource else switchInteractionSource
					) { showSheet = true }
				},
		verticalAlignment = Alignment.CenterVertically
	) {
		BoxedIcon(icon)
		Spacer(8.dp)

		TextWithDescription(
			text = label,
			description = optionLabel(selected),
			modifier = Modifier.weight(1f),
			enabled = enabled
		)

		if (toggled != null) {
			VerticalDivider(
				modifier =
					Modifier
						.height(50.dp)
						.padding(horizontal = 8.dp),
				color =
					MaterialTheme.colorScheme.outline
						.alphaMultiplier(0.7f)
						.semiTransparentIfDisabled(enabled),
				thickness = 1.dp
			)
			Spacer(modifier = Modifier.width(8.dp))
			Switch(
				checked = toggled,
				interactionSource = switchInteractionSource,
				enabled = enabled && switchEnabled,
				onCheckedChange =
					if (toggled) {
						{ onSelected(null) }
					} else {
						null
					},
				thumbContent = {
					val icon = if (toggled) R.drawable.check else R.drawable.close
					Icon(
						painter = painterResource(icon),
						contentDescription = null,
						modifier = Modifier.size(SwitchDefaults.IconSize)
					)
				},
				colors = AppObjectsColors.switchColors()
			)
		}
		ResetIcon(enabled && resetEnabled, onReset)
	}

	if (showSheet) {
		ActionSelector(
			label = label,
			options = options,
			optionLabel = optionLabel,
			optionDesc = optionDesc,
			selected = selected,
			onSelected = onSelected,
			onDismiss = { showSheet = false }
		)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun <T> ActionSelector(
	label: String?,
	options: List<T>,
	optionLabel: @Composable (T) -> String = { it.toString() },
	optionDesc: (@Composable (T) -> String)? = null,
	selected: T?,
	onSelected: (T) -> Unit,
	onDismiss: () -> Unit
) {
	DragonModalBottomSheet(
		onDismissRequest = onDismiss,
		skipPartiallyExpanded = true
	) {
		DragonSettingsGroup(label) {
			options.forEach { option ->
				val isSelected = selected == option
				val interactionSource = rememberInteractionSource()
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.spacedBy(10.dp),
					modifier =
						Modifier
							.dragonSettingGroup(selected = isSelected) {
								clickable(
									interactionSource = interactionSource
								) {
									onSelected(option)
									onDismiss()
								}
							}.padding(10.dp)
				) {
					RadioButton(
						selected = (isSelected),
						onClick = null,
						interactionSource = interactionSource
					)

					TextWithDescription(
						text = optionLabel(option),
						description = optionDesc?.invoke(option)
					)
				}
			}
		}
	}
}
