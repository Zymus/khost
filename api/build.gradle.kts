import org.gradle.kotlin.dsl.support.kotlinCompilerOptions
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    js {
        nodejs()
    }
    jvm()
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64()

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.arrow.core)
            implementation(libs.arrow.core.serialization)
            implementation(libs.arrow.fx.coroutines)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}