plugins {
	alias(libs.plugins.shared.library)
	alias(libs.plugins.shared.compose)
}

android {
	namespace = "io.github.elnix90.shared"

	defaultConfig {
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}

dependencies {
	implementation(libs.androidx.core)
	implementation(libs.androidx.annotation)
	implementation(libs.kotlinx.coroutines.android)

	// Settings library objects (SettingObject based Setting() composables)
	implementation(libs.settings.core)
	implementation(libs.settings.runtime)

	// Compose
	implementation(libs.androidx.material3)
	implementation(libs.androidx.compose.foundation)
	implementation(libs.androidx.compose.foundation.layout)
	implementation(libs.androidx.compose.animation)
	implementation(libs.androidx.compose.animation.core)
	implementation(libs.androidx.compose.runtime)
	implementation(libs.androidx.compose.runtime.retain)
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.graphics)
	implementation(libs.androidx.compose.ui.text)
	implementation(libs.androidx.compose.ui.unit)
	implementation(libs.androidx.compose.ui.geometry)
	implementation(libs.androidx.compose.material3.window.size.class1)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.lifecycle.runtime.compose)
	implementation(libs.androidx.graphics.shapes)
	implementation(libs.androidx.compose.ui.tooling)

	// Instrumented tests (src/androidTest/)
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	androidTestImplementation(libs.androidx.compose.ui.test)
	androidTestImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.ext.junit)

	debugRuntimeOnly(libs.androidx.compose.ui.test.manifest)
}
