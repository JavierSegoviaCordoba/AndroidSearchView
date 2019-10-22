plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    //Classpath dependencies
    implementation("com.android.tools.build:gradle:3.5.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}