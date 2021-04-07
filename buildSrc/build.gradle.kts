plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    //Classpath dependencies
    implementation("com.android.tools.build:gradle:4.0.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.4.30")
    implementation("io.github.gradle-nexus:publish-plugin:1.0.0")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
