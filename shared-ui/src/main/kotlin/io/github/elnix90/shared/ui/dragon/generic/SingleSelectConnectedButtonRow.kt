package io.github.elnix90.shared.ui.dragon.generic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.elnix90.shared.ui.base.components.Spacer
import io.github.elnix90.shared.ui.base.model.SelectButtonOption
import io.github.elnix90.shared.ui.base.remember.rememberInteractionSource
import io.github.elnix90.shared.ui.base.withHapticParam

@Composable
public fun <T : SelectButtonOption> SingleSelectConnectedButtonRow(
	entries: List<T>,
	modifier: Modifier = Modifier,
	checked: (T) -> Boolean,
	enabled: Boolean = true,
	onCheck: (T) -> Unit
) {
	val interactionSources = List(entries.size) { rememberInteractionSource() }

	ButtonGroup(
		overflowIndicator = { ButtonGroupDefaults.OverflowIndicator(it) },
		modifier = modifier.padding(horizontal = 10.dp),
		horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween)
	) {
		entries.forEachIndexed { idx, entry ->

			val checked = checked(entry)

			customItem(
				buttonGroupContent = {
					ToggleButton(
						checked = checked,
						onCheckedChange = withHapticParam { onCheck(entry) },
						interactionSource = interactionSources[idx],
						modifier =
							Modifier
								.weight(1f)
								.animateWidth(interactionSources[idx]),
						enabled = enabled,
						shapes =
							when (idx) {
								0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
								entries.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
								else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
							}
					) {
						entry.iconResId?.let { icon ->
							Icon(
								painter = painterResource(icon),
								contentDescription = null
							)
						}

						if (entry.resId != null && entry.iconResId != null) {
							Spacer(ToggleButtonDefaults.IconSpacing)
						}

						entry.resId?.let { res ->
							Text(
								stringResource(res),
								maxLines = 1,
								softWrap = false,
								style = MaterialTheme.typography.labelSmall
							)
						}
					}
				},
				menuContent = { }
			)
		}
	}
}
