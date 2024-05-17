plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    js(IR) {
        nodejs()
        useCommonJs()
        binaries.executable()
    }
    jvm()
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":api"))
            implementation(project(":serialization"))
            implementation(libs.arrow.core)
            implementation(libs.arrow.fx.coroutines)
            implementation(libs.clikt)
            implementation(libs.kotlinx.coroutines.core)
        }

        jsMain.dependencies {
            implementation(libs.kotlin.wrappers.node)
        }
    }
}
