plugins {
    alias(libs.plugins.kotlinMultiplatform)
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

    sourceSets {
        commonMain.dependencies {
            implementation(project(":api"))
            implementation(libs.arrow.core)
            implementation(libs.arrow.fx.coroutines)
        }
    }
}
