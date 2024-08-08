# KMM-App1 -> iOS & Android withot sharing UI
## About
This is a simple multiplatform application that displays random users' data in a list.
## Resources
[api] -> [link](https://randomuser.me/)

[tutorial] -> [link](https://youtu.be/zI9pyOTeReM?si=Wt5qImvrmhE-zcdq) 

[kotlin serialization] -> [link](https://github.com/Kotlin/kotlinx.serialization)

[kotlinx coroutines] -> [link](https://github.com/Kotlin/kotlinx.coroutines)

[ktor] -> [link](https://github.com/ktorio/ktor)

## Dependencies 
<b>build.gradle.kts</b>
```
plugins {
    kotlin("plugin.serialization") version "2.0.0"
}
...
androidMain.dependencies {
    implementation(libs.ktor.client.android)
}
iosMain.dependencies {
    implementation(libs.ktor.client.darwin)
}
commonMain.dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}
```
<b>libs.versions.toml</b>
```
[versions]
kotlinxSerializationJson = "1.7.1"
kotlinxCoroutinesCore = "1.9.0-RC"
ktor = "3.0.0-beta-2"

[libraries]
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }
kotlinx-coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "kotlinxCoroutinesCore" }
ktor-client-core = { module = "io.ktor:ktor-client-core", version.ref = "ktor" }
ktor-client-content-negotiation = { module = "io.ktor:ktor-client-content-negotiation", version.ref = "ktor" }
ktor-serialization-kotlinx-json = { module = "io.ktor:ktor-serialization-kotlinx-json", version.ref = "ktor" }
ktor-client-android = { module = "io.ktor:ktor-client-android", version.ref = "ktor" }
ktor-client-darwin = { module = "io.ktor:ktor-client-darwin", version.ref = "ktor" }
```

## Results
| ios | android | 
| ------------- | ------------- | 
|  <img src="/KMM-App1/images/ios.png" width="250"> | <img src="/KMM-App1/images/android.png" width="250"> | 
