import com.javiersc.plugins.extensions.bintray
import com.javiersc.plugins.extensions.publishing
import java.util.*

apply(plugin = Plugins.bintray)
apply(plugin = Plugins.mavenPublish)

val localProperties =
    Properties().apply { load(rootProject.file("local.properties").inputStream()) }

bintray {
    user = localProperties.getProperty(Bintray.user)
    key = localProperties.getProperty(Bintray.key)
    publish = true
    pkg.apply {
        repo = Bintray.repo
        name = Bintray.name
        userOrg = Bintray.userOrg
        description = Bintray.description
        websiteUrl = Bintray.websiteUrl
        setLicenses(Bintray.licenses)
        issueTrackerUrl = Bintray.issueTrackerUrl
        vcsUrl = Bintray.vscUrl
        version.apply { name = Bintray.version }
        setLabels(Bintray.label1, Bintray.label2, Bintray.label3, Bintray.label4)
    }
    setPublications(Bintray.name)
}

publishing {
    publications {
        create<MavenPublication>(Bintray.name) {
            groupId = Bintray.groupId
            artifactId = Bintray.artifactId
            version = Bintray.version
            artifact(Bintray.artifactAar)
        }
    }
}