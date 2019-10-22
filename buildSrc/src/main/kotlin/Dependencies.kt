object Dependencies {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val coreKTX = "androidx.core:core-ktx:${Versions.coreKTX}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

        object DataBinding {
            const val runtime = "androidx.databinding:databinding-common:${Versions.gradle}"
            const val compiler = "androidx.databinding:compiler:${Versions.databindingCompiler}"
        }
    }
    const val material = "com.google.android.material:material:${Versions.material}"
}