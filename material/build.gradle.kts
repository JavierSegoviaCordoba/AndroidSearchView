plugins {
    AndroidSetup
}

android {
    defaultConfig {
        versionCode = Build.versionCode
        versionName = Build.versionName
    }
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    Dependencies.AndroidX.apply {
        implementation(appCompat)
        implementation(constraintLayout)
        implementation(coreKTX)
        implementation(recyclerView)
    }
    implementation(Dependencies.material)
}