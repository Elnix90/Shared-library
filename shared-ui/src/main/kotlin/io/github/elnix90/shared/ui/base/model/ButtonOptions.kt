package io.github.elnix90.shared.ui.base.model

/**
 * Contract for an option displayed as a connected toggle button.
 *
 * [resId], [iconEnabled] and [iconDisabled] are caller-provided resource ids
 * (or null) resolved against the consuming application at runtime.
 */
public interface ToggleButtonOption {
	public val resId: Int?
	public val iconEnabled: Int?
	public val iconDisabled: Int?
}

/**
 * Contract for an option displayed as a connected select button.
 */
public interface SelectButtonOption {
	public val resId: Int?
	public val iconResId: Int?
}
