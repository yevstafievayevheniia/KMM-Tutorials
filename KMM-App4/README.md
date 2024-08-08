# KMM-App4 -> Navigation using Decompose
## About
This is a simple multiplatform application that displays random products' data in a list.

## Resources
[api] -> [link](https://fakestoreapi.com/)

[tutorial] -> [link](https://youtu.be/h0dAozvpm5M?si=SU1K68mIg2OQz5lt)

[decompose lib] -> [link](https://arkivanov.github.io/Decompose/)

## Dependencies 
<b>build.gradle.kts</b>
```
commonMain.dependencies {
    implementation(libs.decompose)
    implementation(libs.decompose.extensions.compose)
}
```
<b>libs.versions.toml</b>
```
[versions]
decompose = "3.1.0"

[libraries]
decompose = { module = "com.arkivanov.decompose:decompose", version.ref = "decompose" }
decompose-extensions-compose = { module = "com.arkivanov.decompose:extensions-compose", version.ref = "decompose" }
```
## Environment 
To launch the desktop, add the following environment
```
composeApp:run
```
To launch the web browser, add the following environment
```
composeApp:jsBrowserDevelopmentRun
```
<img src="https://github.com/user-attachments/assets/9161100d-c933-4848-b01a-86af68522eb7" width="500" >

## Results
| ios |
| ------------- |
|  <video src="https://github.com/user-attachments/assets/3976427e-2daf-472e-8dc6-cf21829b457c">
