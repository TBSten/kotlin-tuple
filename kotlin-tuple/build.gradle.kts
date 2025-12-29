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
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
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
    coordinates("me.tbsten.kotlin.tuple", "kotlin-tuple", "1.0.0")

    pom {
        name = "kotlin-tuple"
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

val generateTupleDefinitions by tasks.registering {
    val tupleKt = generateSourceDir.file("Tuple.kt")
    doLast {
        tupleKt.asFile.apply {
            parentFile.mkdirs()
            bufferedWriter().use { writer ->
                writer.appendLine("package $generatePackage")
                writer.appendLine("")

                fun appendTupleCode(tupleCount: Int) {
                    when (tupleCount) {
                        0 -> writer.appendLine(
                            """
                            data object Tuple0 {
                                override fun toString(): String = "()"
                            }
                            """.trimIndent()
                        )

                        2 -> writer.appendLine("typealias Tuple2<A1, A2> = Pair<A1, A2>")
                        3 -> writer.appendLine("typealias Tuple3<A1, A2, A3> = Triple<A1, A2, A3>")
                        else -> {
                            writer.appendLine(
                                "data class Tuple$tupleCount<${
                                    List(tupleCount) { "A$it" }.joinToString(", ")
                                }>("
                            )
                            repeat(tupleCount) { count ->
                                writer.appendLine("    val a$count: A$count,")
                            }
                            writer.appendLine(") {")

                            writer.appendLine(
                                "    override fun toString(): String = \"(${
                                    List(tupleCount) { "\$a$it" }.joinToString(", ")
                                })\""
                            )

                            writer.appendLine("}")
                        }
                    }
                    writer.appendLine()
                }

                generateTupleRange.forEach(::appendTupleCode)
            }
        }
    }
}

val generateTupleFactory by tasks.registering {
    val tupleFactoryKt = generateSourceDir.file("TupleFactory.kt")

    doLast {
        tupleFactoryKt.asFile.apply {
            parentFile.mkdirs()
            bufferedWriter().use { writer ->
                writer.appendLine("package $generatePackage")
                writer.appendLine("")

                fun appendTupleFactoryCode(tupleCount: Int) {
                    when (tupleCount) {
                        0 -> writer.appendLine(
                            """
                            |fun tupleOf(): Tuple0 = 
                            |   Tuple0
                        """.trimMargin()
                        )

                        else -> writer.appendLine(
                            """
                            |fun <${List(tupleCount) { "A$it" }.joinToString(", ")}> tupleOf(${
                            List(tupleCount) { "a$it: A$it" }.joinToString(
                                ", "
                            )
                        }): Tuple$tupleCount<${List(tupleCount) { "A$it" }.joinToString(", ")}> = 
                            |   Tuple$tupleCount(${List(tupleCount) { "a$it" }.joinToString(", ")})
                        """.trimMargin()
                        )
                    }
                    writer.appendLine("")
                }
                generateTupleRange.forEach(::appendTupleFactoryCode)
            }
        }
    }
}

val generateAll by tasks.registering {
    dependsOn(generateTupleDefinitions)
    dependsOn(generateTupleFactory)
}
