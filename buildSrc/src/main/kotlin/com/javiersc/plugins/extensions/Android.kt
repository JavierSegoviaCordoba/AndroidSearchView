package com.javiersc.plugins.extensions

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal inline fun Project.android(block: BaseExtension.() -> Unit) {
    val baseExtension = this.extensions.getByType<BaseExtension>()
    return block(baseExtension)
}

internal fun Project.dependencies(configuration: DependencyHandlerScope.() -> Unit) =
    DependencyHandlerScope.of(dependencies).configuration()

internal fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

internal fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

internal fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

internal fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

internal val Project.isAndroidApplication get() = this.name == "app"

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.release(
    crossinline buildType: BuildType.() -> Unit
): T = this.getByName("release") { buildType(this) }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.debug(
    crossinline buildType: BuildType.() -> Unit
): T = this.getByName("debug") { buildType(this) }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.pro(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("pro") { buildType(this).apply { initWith(getByName("release")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.pre(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("pre") { buildType(this).apply { initWith(getByName("release")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.beta(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("beta") { buildType(this).apply { initWith(getByName("release")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.alpha(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("alpha") { buildType(this).apply { initWith(getByName("release")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.dev(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("dev") { buildType(this).apply { initWith(getByName("debug")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.internal(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("internal") { buildType(this).apply { initWith(getByName("debug")) } }

internal inline fun <reified T : BuildType> NamedDomainObjectContainer<T>.mock(
    crossinline buildType: BuildType.() -> Unit
): T = this.create("mock") { buildType(this).apply { initWith(getByName("debug")) } }

internal fun Project.kotlinOptions(kotlinJvmOptions: KotlinJvmOptions.() -> Unit) {
    tasks.withType(KotlinCompile::class).all { kotlinOptions(kotlinJvmOptions) }
}