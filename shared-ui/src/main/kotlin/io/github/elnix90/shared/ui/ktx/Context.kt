package io.github.elnix90.shared.ui.ktx

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * Shows a toast message on the main thread. Silently ignores blank or null messages.
 *
 * @param message the message to display
 * @param duration toast duration ([Toast.LENGTH_SHORT] or [Toast.LENGTH_LONG])
 */
public fun Context.showToast(
	message: Any?,
	duration: Int = Toast.LENGTH_SHORT
) {
	val context = this
	Handler(Looper.getMainLooper()).post {
		if (message is String && message.isNotBlank()) {
			Toast.makeText(context, message, duration).show()
		}
	}
}
