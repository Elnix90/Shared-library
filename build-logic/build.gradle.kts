plugins {
	`kotlin-dsl`
	`java-gradle-plugin`
}

group = "io.github.elnix90.shared.buildlogic"

dependencies {
	compileOnly(libs.android.gradle.plugin)
	compileOnly(libs.android.gradle.api)
	compileOnly(libs.kotlin.gradle.plugin.api)
	compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
	plugins {
		register("sharedLibrary") {
			id = "shared.library"
			implementationClass = "shared.buildlogic.SharedAndroidLibraryPlugin"
		}
		register("sharedCompose") {
			id = "shared.compose"
			implementationClass = "shared.buildlogic.SharedAndroidComposePlugin"
		}
	}
}
