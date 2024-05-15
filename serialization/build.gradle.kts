plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    js {
        browser()
        nodejs()
    }
    jvm()
    linuxX64()
    macosX64()
    mingwX64()
}