import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)

    kotlin("plugin.serialization") version "2.0.0"
    id("app.cash.sqldelight") version "2.0.2"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    jvm("desktop")

    js(IR) {
        moduleName = "KMM-App7"
        browser() {
            commonWebpackConfig() {
                outputFileName = "KMM-App7.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy()
            }
            binaries.executable()
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            export(libs.decompose)
            export(libs.lifecycle)
        }
    }
    
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.ktor.client.android)
            implementation(libs.koin.android)
            implementation(libs.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            api(libs.decompose)
            api(libs.lifecycle)
            implementation(libs.native.driver)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.sqlite.driver)
        }
        jsMain.dependencies {
            implementation(libs.web.worker.driver)
            implementation(devNpm("copy-webpack-plugin", "9.1.0"))
            implementation(npm("@cashapp/sqldelight-sqljs-worker", "2.0.2"))
            implementation(npm("sql.js", "1.8.0"))
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.mvvm.core)
            api(libs.image.loader)
            implementation(libs.decompose)
            implementation(libs.decompose.extensions.compose)
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "org.jarvist.kmmapp7"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.jarvist.kmmapp7"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}
dependencies {
    implementation(libs.androidx.runtime.android)
}

compose.desktop {
    application {
        mainClass = "org.jarvist.kmmapp7.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.jarvist.kmmapp7"
            packageVersion = "1.0.0"
        }
    }
}

compose.experimental {
    web.application {}
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("org.jarvist.kmmapp7")
            generateAsync.set(true)
        }
    }
}
