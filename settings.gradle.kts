pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

includeBuild("build-logic")

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
		maven { url = uri("https://jitpack.io") }
	}
}

rootProject.name = "Shared-ui"
include(":shared-ui")
