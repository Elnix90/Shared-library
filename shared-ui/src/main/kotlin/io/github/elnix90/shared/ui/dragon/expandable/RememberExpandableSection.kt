package io.github.elnix90.shared.ui.dragon.expandable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.elnix90.shared.ui.dragon.model.ExpandableSectionState

@Composable
public fun rememberExpandableSection(
	title: Int,
	description: Int?,
	icon: Int?,
	customLeadingContent: (@Composable () -> Unit)? = null,
	skipPartiallyExpanded: Boolean = true,
	enabled: Boolean = true
): ExpandableSectionState {
	var isExpanded by remember { mutableStateOf(false) }

	return remember(title, description, enabled) {
		ExpandableSectionState(
			isExpanded = { isExpanded },
			enabled = enabled,
			title = title,
			description = description,
			icon = icon,
			customLeadingContent = customLeadingContent,
			skipPartiallyExpanded = skipPartiallyExpanded,
			toggle = { isExpanded = !isExpanded }
		)
	}
}
