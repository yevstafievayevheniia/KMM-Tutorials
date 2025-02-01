# KMM-ToDoApp -> Navigation using Voyager + MongoDB
## About
This is a simple multiplatform application that tasks.

## Resources

[tutorial] -> [link](https://youtu.be/1TLk36FdmMA?si=GzSr6mOmMw3o3lFp)

[voyager lib] -> [link](https://voyager.adriel.cafe/)

[realm lib] -> [link](https://github.com/realm/realm-kotlin)

## Dependencies 
<b>build.gradle.kts</b>
```
commonMain.dependencies {
  implementation(libs.navigator)
  implementation(libs.navigator.screen.model)
  implementation(libs.navigator.transitions)
  implementation(libs.navigator.koin)
  implementation(libs.koin.core)

  implementation(libs.mongodb.realm)
  implementation(libs.kotlin.coroutines)
  implementation(libs.stately.common)
}
```
<b>libs.versions.toml</b>
```
[versions]
voyager = "1.0.0"
koin = "3.5.6"
realm = "3.0.0"
coroutines = "1.8.1"
stately = "2.0.5"

[libraries]
navigator = { module = "cafe.adriel.voyager:voyager-navigator", version.ref = "voyager" }
navigator-screen-model = { module = "cafe.adriel.voyager:voyager-screenmodel", version.ref = "voyager" }
navigator-transitions = { module = "cafe.adriel.voyager:voyager-transitions", version.ref = "voyager" }
navigator-koin = { module = "cafe.adriel.voyager:voyager-koin", version.ref = "voyager" }
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koin" }
mongodb-realm = { module = "io.realm.kotlin:library-base", version.ref = "realm" }
kotlin-coroutines = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "coroutines" }
stately-common = { module = "co.touchlab:stately-common", version.ref = "stately" }

[plugins]
realm-plugin = { id = "io.realm.kotlin", version.ref = "realm" }
```

## Results
| ios |
| ------------- |
|  <video src="https://github.com/user-attachments/assets/f06d39c6-07a6-4642-a2dd-4705322124a8">

