package io.github.elnix90.shared.ui.dragon.expandable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.elnix90.shared.R
import io.github.elnix90.shared.ui.animation.bouncySpec
import io.github.elnix90.shared.ui.base.components.BoxedIcon
import io.github.elnix90.shared.ui.base.modifiers.conditional
import io.github.elnix90.shared.ui.dragon.components.DragonGroupScope
import io.github.elnix90.shared.ui.dragon.components.DragonModalBottomSheet
import io.github.elnix90.shared.ui.dragon.components.DragonSettingsGroup
import io.github.elnix90.shared.ui.dragon.model.ExpandableSectionState
import io.github.elnix90.shared.ui.dragon.text.TextWithDescription
import io.github.elnix90.shared.ui.ktx.alphaMultiplier
import io.github.elnix90.shared.ui.ktx.semiTransparentIfDisabled

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun DragonGroupScope.ExpandableSection(
	state: ExpandableSectionState,
	content: @Composable DragonGroupScope.() -> Unit
) {
	val enabled = state.enabled
	val expanded = state.isExpanded() && enabled

	val rotationDegrees =
		animateFloatAsState(
			targetValue = if (expanded) 0f else -90f,
			animationSpec = bouncySpec()
		)

	val backgroundColor by animateColorAsState(
		targetValue =
			when {
				!enabled -> MaterialTheme.colorScheme.surfaceVariant.alphaMultiplier(0.5f)
				expanded -> MaterialTheme.colorScheme.surfaceVariant
				else -> MaterialTheme.colorScheme.surface
			}.semiTransparentIfDisabled(enabled)
	)

	val contentColor = contentColorFor(backgroundColor)

	Column(
		modifier =
			Modifier
				.dragonSettingGroup(enabled = enabled) {
					conditional(!expanded && enabled) {
						clickable {
							state.toggle()
						}
					}
				}
	) {
		Row(
			modifier =
				Modifier
					.conditional(expanded) {
						clickable {
							state.toggle()
						}
					},
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			if (state.icon != null) {
				BoxedIcon(state.icon)
			} else {
				state.customLeadingContent!!()
			}

			TextWithDescription(
				text = stringResource(state.title),
				description = if (state.description != null) stringResource(state.description) else null,
				modifier = Modifier.weight(1f),
				enabled = enabled
			)

			Icon(
				painter = painterResource(R.drawable.arrow_drop_down),
				contentDescription = "Expanded chevron indicator",
				tint = contentColor.semiTransparentIfDisabled(enabled),
				modifier =
					Modifier
						.size(30.dp)
						.rotate(rotationDegrees.value)
			)
		}
	}

	if (expanded) {
		DragonModalBottomSheet(
			onDismissRequest = state.toggle,
			skipPartiallyExpanded = state.skipPartiallyExpanded
		) {
			DragonSettingsGroup(
				modifier = Modifier.verticalScroll(rememberScrollState())
			) {
				content()
			}
		}
	}
}
