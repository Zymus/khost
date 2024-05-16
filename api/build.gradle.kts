plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useFirefox()
                }
            }
        }
        nodejs()
    }
    jvm()
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization)
            implementation(libs.arrow.core)
            implementation(libs.arrow.core.serialization)
            implementation(libs.arrow.fx.coroutines)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}