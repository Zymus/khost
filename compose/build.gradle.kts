plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useFirefox()
                    useFirefoxHeadless()
                }
            }
        }
        binaries.executable()
    }
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":api"))
            implementation(compose.runtime)
            implementation(libs.arrow.core)
            implementation(libs.arrow.fx.coroutines)
        }
    }
}
compose.desktop {

}