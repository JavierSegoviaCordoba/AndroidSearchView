plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.appcompat:appcompat:1.1.0-rc01")

    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta2")
    implementation("androidx.core:core-ktx:1.2.0-alpha02")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.41")
    implementation("com.google.android.material:material:1.1.0-alpha07")
    implementation("androidx.recyclerview:recyclerview:1.1.0-beta01")

}