pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()

        flatDir {
            dirs("kyc-sdk/libs")
        }
    }


}


rootProject.name = "kyc_sdk_android"
include(":kyc-sdk")