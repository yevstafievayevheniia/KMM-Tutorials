# KMM-App7 -> SQLDelight
## About
This is a simple multiplatform application that displays random products' data in a list.

## Resources
[api] -> [link](https://fakestoreapi.com/)

[tutorial] -> [link](https://youtu.be/iRlfJcnLFF8?si=TmsOkZm-TCc7DTGL)

[SQLDelight lib] -> [link](https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/)

## Dependencies 
<b>build.gradle.kts</b>
```
plugins {
    id("app.cash.sqldelight") version "2.0.2"
}
...
androidMain.dependencies {
    implementation(libs.android.driver)
}
iosMain.dependencies {
    implementation(libs.native.driver)
}
desktopMain.dependencies {
    implementation(libs.sqlite.driver)
}
jsMain.dependencies {
    implementation(libs.web.worker.driver)
    implementation(devNpm("copy-webpack-plugin", "9.1.0"))
    implementation(npm("@cashapp/sqldelight-sqljs-worker", "2.0.2"))
    implementation(npm("sql.js", "1.8.0"))
}
```
<b>libs.versions.toml</b>
```
[versions]
nativeDriver = "2.0.2"

[libraries]
android-driver = { module = "app.cash.sqldelight:android-driver", version.ref = "nativeDriver" }
native-driver = { module = "app.cash.sqldelight:native-driver", version.ref = "nativeDriver" }
sqlite-driver = { module = "app.cash.sqldelight:sqlite-driver", version.ref = "nativeDriver" }
web-worker-driver = { module = "app.cash.sqldelight:web-worker-driver", version.ref = "nativeDriver" }
```
## Environment 
To launch the ios simulator, add the following in XCode 
```
-lsqlite3
```
<img src="https://github.com/user-attachments/assets/a1f114a8-48e8-496f-baf7-8c7e5c57686f" width="500" >

To launch the desktop, add the following environment
```
composeApp:run
```
To launch the web browser, add the following environment
```
composeApp:jsBrowserDevelopmentRun
```
<img src="https://github.com/user-attachments/assets/9161100d-c933-4848-b01a-86af68522eb7" width="500" >
