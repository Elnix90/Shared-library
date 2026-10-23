package shared.buildlogic

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class SharedAndroidLibraryPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			pluginManager.apply("com.android.library")
			pluginManager.apply("com.vanniktech.maven.publish")

			configureKotlinAndroid()

			extensions.configure(LibraryExtension::class.java) {
				compileSdk {
					version = release(COMPILE_SDK)
				}

				defaultConfig {
					minSdk = MIN_SDK
				}

				compileOptions {
					sourceCompatibility = JAVA_VERSION
					targetCompatibility = JAVA_VERSION
				}

				packaging {
					jniLibs.keepDebugSymbols.add("**/*.so")
				}
			}
		}
	}
}
