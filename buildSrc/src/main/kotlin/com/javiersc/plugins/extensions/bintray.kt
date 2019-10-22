package com.javiersc.plugins.extensions

import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.named

internal inline fun Project.bintray(block: BintrayExtension.() -> Unit) {
    val bintrayExtension = this.extensions.getByType<BintrayExtension>()
    return block(bintrayExtension)
}

internal inline fun Project.publishing(block: PublishingExtension.() -> Unit) {
    val publishingExtension = this.extensions.getByType<PublishingExtension>()
    return block(publishingExtension)
}

internal val Project.sourceSets: SourceSetContainer get() = extensions.getByType()

@Suppress("extension_shadowed_by_member")

internal val SourceSetContainer.main: NamedDomainObjectProvider<SourceSet>
    get() = named<SourceSet>("main")
