import com.javiersc.plugins.extensions.*

if (isAndroidApplication) apply(plugin = Plugins.androidApplication)
else apply(plugin = Plugins.androidLibrary)
apply(plugin = Plugins.Kotlin.android)
apply(plugin = Plugins.Kotlin.androidExtensions)
apply(plugin = Plugins.Kotlin.kapt)

android {
    compileSdkVersion(Android.compileSdkVersion)
    defaultConfig {
        if (isAndroidApplication) applicationId = Android.applicationId
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = Android.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = Android.releaseIsMinifyEnabled
            proguardFiles(getDefaultProguardFile(Android.proguardAndroid), Android.proguardRules)
        }
        debug {
            isMinifyEnabled = Android.debugIsMinifyEnabled
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_1_8}"
    }
}


