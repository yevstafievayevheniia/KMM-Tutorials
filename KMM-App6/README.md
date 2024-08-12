# KMM-App6 -> Koin
## About
This is a simple multiplatform application that displays random products' data in a list.

## Resources
[api] -> [link](https://fakestoreapi.com/)

[tutorial] -> [link](https://youtu.be/X0nc2knu43E?si=FGfD692cTJWucTQl)

[koin lib] -> [link](https://insert-koin.io/)

## Dependencies 
<b>build.gradle.kts</b>
```
androidMain.dependencies {
    implementation(libs.koin.android)
}
...
commonMain.dependencies {
    implementation(libs.koin.core)
}
```
<b>libs.versions.toml</b>
```
[versions]
koinCore = "4.0.0-RC1"

[libraries]
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koinCore" }
koin-android = { module = "io.insert-koin:koin-android", version.ref = "koinCore" }
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
