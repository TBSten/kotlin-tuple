# kotlin-tuple

> [!CAUTION]
> This library is deprecated.
> It is recommended that you use TBSten/skills `kotlin-tuple` skill to generate tuple code for each project.
> 
> https://github.com/TBSten/skills/blob/main/skills/kotlin-tuple.md

Kotlin Multiplatform Library

### Run Sample App

 - Desktop JVM: `./gradlew :sample:composeApp:run`
 - Android: `open project in Android Studio and run the sample app`
 - iOS: `open 'sample/iosApp/iosApp.xcodeproj' in Xcode and run the sample app`
 - JavaScript: `./gradlew :sample:composeApp:jsBrowserRun`
 - Wasm: `./gradlew :sample:composeApp:wasmJsBrowserRun`
 - Linux/Macos/Windows native: `./gradlew :sample:terminalApp:runDebugExecutable[architecture]`

### Publish to MavenLocal

1) Run `./gradlew :kotlin-tuple:publishToMavenLocal`
2) Open `~/.m2/repository/me/tbsten/kotlin/tuple/`

### Publish to MavenCentral

1) Create an account and a namespace on Sonatype:  
   https://central.sonatype.org/register/central-portal/#create-an-account
2) Add developer id, name, email and the project url to  
   `./kotlin-tuple/build.gradle.kts`
3) Generate a GPG key:  
   https://getstream.io/blog/publishing-libraries-to-mavencentral-2021/#generating-a-gpg-key-pair
   ```
   gpg --full-gen-key
   gpg --keyserver keyserver.ubuntu.com --send-keys XXXXXXXX
   gpg --export-secret-key XXXXXXXX > XXXXXXXX.gpg
   ```
4) Add these lines to `gradle.properties`:
   ```
   signing.keyId=XXXXXXXX
   signing.password=[key password]
   signing.secretKeyRingFile=../XXXXXXXX.gpg
   mavenCentralUsername=[generated username]
   mavenCentralPassword=[generated password]
   ```
5) Run `./gradlew :kotlin-tuple:publishAndReleaseToMavenCentral --no-configuration-cache`
