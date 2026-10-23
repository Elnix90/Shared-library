plugins {
	alias(libs.plugins.shared.library)
	alias(libs.plugins.shared.compose)
}

android {
	namespace = "io.github.elnix90.shared"
}

dependencies {
	implementation(libs.androidx.core)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)

	// Integration with activities
	implementation(libs.androidx.activity.compose)
	// Compose Material Design
	implementation(libs.androidx.material3)
	implementation(libs.androidx.compose.material3.window.size.class1)
	// Animations
	implementation(libs.androidx.compose.animation)
	// Tooling support (Previews, etc.)
	implementation(libs.androidx.compose.ui.tooling)
	// Integration with ViewModels
	implementation(libs.androidx.lifecycle.viewmodel.compose)
}
