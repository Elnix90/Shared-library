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
	// Compose (part of the public API surface)
	api(libs.androidx.compose.animation)
	api(libs.androidx.compose.animation.core)
	api(libs.androidx.compose.foundation)
	api(libs.androidx.compose.foundation.layout)
	api(libs.androidx.compose.runtime)
	api(libs.androidx.compose.ui)
	api(libs.androidx.compose.ui.graphics)
	api(libs.androidx.compose.ui.text)
	api(libs.androidx.compose.ui.unit)
	api(libs.androidx.graphics.shapes)
	api(libs.androidx.material3)
	api(libs.kotlinx.coroutines.core)

	// AndroidX / Kotlin
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.annotation)
	implementation(libs.androidx.compose.runtime.annotation)
	implementation(libs.androidx.compose.runtime.retain)
	implementation(libs.androidx.compose.ui.geometry)
	implementation(libs.androidx.compose.ui.tooling)
	implementation(libs.androidx.core)
	implementation(libs.androidx.lifecycle.common)
	implementation(libs.androidx.lifecycle.runtime.compose)
	runtimeOnly(libs.kotlinx.coroutines.android)

	// Instrumented tests (src/androidTest/)
	androidTestImplementation(libs.androidx.activity)
	androidTestImplementation(libs.androidx.compose.ui.test)
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.junit)
	debugRuntimeOnly(libs.androidx.compose.ui.test.manifest)

	// androidx.core:core-ktx was merged into androidx.core:core as of 1.19 (the 1.19.1 ktx
	// artifact is empty). Align the transitive core-ktx:1.18.0 pulled in by androidx.activity
	// so its old classes don't duplicate the ones now shipped in core.
	constraints {
		implementation(libs.androidx.core.ktx)
	}
}
