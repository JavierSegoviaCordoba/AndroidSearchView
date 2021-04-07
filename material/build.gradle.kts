import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlin-android-extensions")
    `maven-publish`
    signing
    id("org.jetbrains.dokka")
}

group = "com.javiersc.androidsearchview"
version = "0.1.0"

android {
    defaultConfig {
        compileSdkVersion(Android.compileSdkVersion)
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)
        versionCode = Build.versionCode
        versionName = Build.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets.all {
        java.srcDir("src/android${name.capitalize()}/java")
        res.srcDir("src/android${name.capitalize()}/res")
        manifest.srcFile("src/android${name.capitalize()}/AndroidManifest.xml")
    }
}

tasks.withType<KotlinCompile> { kotlinOptions { jvmTarget = "1.8" } }

kotlin {
    android { publishAllLibraryVariants() }

    sourceSets {
        named("androidMain") {
            dependencies {
                Dependencies.AndroidX.apply {
                    implementation(appCompat)
                    implementation(constraintLayout)
                    implementation(coreKTX)
                    implementation(recyclerView)
                }
                implementation(Dependencies.material)
            }
        }
    }
}

val docsJar by project.tasks.creating(Jar::class) {
    group = "build"
    description = "Assembles Javadoc jar file from for publishing"
    archiveClassifier.set("javadoc")
    dependsOn(tasks.named<DokkaTask>("dokkaHtml"))
}

configure<SigningExtension> {
    if (!project.version.toString().endsWith("-SNAPSHOT")) {
        useGpgCmd()
        sign(extensions.getByName<PublishingExtension>("publishing").publications)
    }
}

configure<PublishingExtension> {
    publications {
        withType<MavenPublication> {
            pom {
                name.set(property("pomName").toString())
                description.set(property("pomDescription").toString())
                url.set(property("pomUrl").toString())

                licenses {
                    license {
                        name.set(property("pomLicenseName").toString())
                        url.set(property("pomLicenseUrl").toString())
                    }
                }

                developers {
                    developer {
                        id.set(property("pomDeveloperId").toString())
                        name.set(property("pomDeveloperName").toString())
                        email.set(property("pomDeveloperEmail").toString())
                    }
                }

                scm {
                    url.set(property("pomSmcUrl").toString())
                    connection.set(property("pomSmcConnection").toString())
                    developerConnection.set(property("pomSmcDeveloperConnection").toString())
                }
            }

            artifact(docsJar)
        }
    }
}
