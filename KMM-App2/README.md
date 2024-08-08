# KMM-App2 -> iOS & Android & Desktop with sharing UI
## About
This is a simple multiplatform application that displays random products' data in a list.

## Resources
[api] -> [link](https://fakestoreapi.com/)

[tutorial] -> [link](https://youtu.be/TqQkv3bVMYc?si=VbBH5-0MHyVPdCuG) 

[kotlin serialization] -> [link](https://github.com/Kotlin/kotlinx.serialization)

[kotlinx coroutines] -> [link](https://github.com/Kotlin/kotlinx.coroutines)

[ktor] -> [link](https://github.com/ktorio/ktor)

[moko mvvm] -> [link](https://github.com/icerockdev/moko-mvvm)

[compose imageloader] -> [link](https://github.com/qdsfdhvh/compose-imageloader)

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
    implementation(libs.mvvm.core)
    api(libs.image.loader)
}
```
<b>libs.versions.toml</b>
```
[versions]
kotlinxSerializationJson = "1.7.1"
kotlinxCoroutinesCore = "1.9.0-RC"
ktor = "3.0.0-beta-2"
mvvmCore = "0.16.1"
imageLoader = "1.8.2"

[libraries]
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }
kotlinx-coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "kotlinxCoroutinesCore" }
ktor-client-core = { module = "io.ktor:ktor-client-core", version.ref = "ktor" }
ktor-client-content-negotiation = { module = "io.ktor:ktor-client-content-negotiation", version.ref = "ktor" }
ktor-serialization-kotlinx-json = { module = "io.ktor:ktor-serialization-kotlinx-json", version.ref = "ktor" }
ktor-client-android = { module = "io.ktor:ktor-client-android", version.ref = "ktor" }
ktor-client-darwin = { module = "io.ktor:ktor-client-darwin", version.ref = "ktor" }
mvvm-core = { module = "dev.icerock.moko:mvvm-core", version.ref = "mvvmCore" }
image-loader = { module = "io.github.qdsfdhvh:image-loader", version.ref = "imageLoader" }
```

## Results
| ios | android | desktop |
| ------------- | ------------- | ------------- |  
|  <img src="https://github.com/user-attachments/assets/3847aab7-358c-4813-bfde-a8f397148eb1" width="250"> | <img src="https://github.com/user-attachments/assets/ef448e0d-0ac4-4d34-960a-10b768244eb3" width="250"> | <img src="https://github.com/user-attachments/assets/5aa8ff25-7011-42b5-951b-0539f2ee64c9" width="500"> | 
