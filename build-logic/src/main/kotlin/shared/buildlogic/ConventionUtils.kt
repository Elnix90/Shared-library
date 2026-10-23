package shared.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal const val COMPILE_SDK = 37
internal const val MIN_SDK = 26
internal const val TARGET_SDK = 37

internal val JAVA_VERSION: JavaVersion = JavaVersion.VERSION_21

internal fun Project.configureKotlinAndroid() {
	extensions.configure(KotlinAndroidProjectExtension::class.java) {
		jvmToolchain(JAVA_VERSION.majorVersion.toInt())
		explicitApi()
	}
}
