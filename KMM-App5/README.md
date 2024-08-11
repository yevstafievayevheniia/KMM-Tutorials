# KMM-App5 -> iOS Liffecycle
## About
This is a simple multiplatform application that displays random products' data in a list.

## Resources
[api] -> [link](https://fakestoreapi.com/)

[tutorial] -> [link](https://youtu.be/-QqcJGylbSo?si=D3i1AzhIS4uYTEhS)

[decompose lifecycle lib] -> [link](https://github.com/arkivanov/Essenty)

## Dependencies 
<b>build.gradle.kts</b>
```
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
    ...
    iosMain.dependencies {
        api(libs.decompose)
        api(libs.lifecycle)
    }

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
| ios Lifecycle |
| ------------- |
|  <video src="https://github.com/user-attachments/assets/9bac760a-8d12-463e-87da-ee5b2fbd58fd"> |
