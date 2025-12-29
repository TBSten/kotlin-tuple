plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

kotlin {
    jvmToolchain(17)

    androidTarget { publishLibraryVariants("release") }
    jvm()
    js { browser() }
    wasmJs { browser() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":kotlin-tuple"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        all {
            languageSettings.enableLanguageFeature("ContextParameters")
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compileTaskProvider.configure {
            compilerOptions {
                freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }

}

android {
    namespace = "me.tbsten.kotlin.tuple"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }
}

//Publishing your Kotlin Multiplatform library to Maven Central
//https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-publish-libraries.html
mavenPublishing {
    publishToMavenCentral()
    coordinates("me.tbsten.kotlin.tuple", "context-parameter", "1.0.0")

    pom {
        name = "context-parameter"
        description = "Kotlin Multiplatform library"
        url = "github url" //todo

        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        developers {
            developer {
                id = "" //todo
                name = "" //todo
                email = "" //todo
            }
        }

        scm {
            url = "github url" //todo
        }
    }
    if (project.hasProperty("signing.keyId")) signAllPublications()
}

// generate files
val generatePackage = "me.tbsten.kotlin.tuple"
val generateSourceDir = project.layout
    .projectDirectory
    .dir("src/commonMain/kotlin/${generatePackage.replace('.', '/')}")

val generateTupleRange = 0..20

val generateContextParameterTuple by tasks.registering {
    val tupleFactoryKt = generateSourceDir.file("ContextParameterTuple.kt")
    val generateTupleRange = 2..20

    doLast {
        tupleFactoryKt.asFile.apply {
            parentFile.mkdirs()
            bufferedWriter().use { writer ->
                writer.appendLine("package $generatePackage")
                writer.appendLine("")

                fun appendTupleFactoryCode(tupleCount: Int) {
                    writer.appendLine(
                        """
                        context(${List(tupleCount) { "_: A$it" }.joinToString(", ")})
                        fun <${List(tupleCount) { "A$it" }.joinToString(", ")}> contextOf() =
                            tupleOf(${List(tupleCount) { "contextOf<A$it>()" }.joinToString(", ")})
                    """.trimIndent()
                    )

                    writer.appendLine("")
                }
                generateTupleRange.forEach(::appendTupleFactoryCode)
            }
        }
    }
}

val generateAll by tasks.registering {
    dependsOn(generateContextParameterTuple)
}
