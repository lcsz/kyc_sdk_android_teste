plugins {
    id("com.android.library") version "8.2.1"
    id("maven-publish")
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    namespace = "com.github.lcsz.kyc_sdk_android"

    compileSdk = 34
//    defaultConfig {
//        minSdk 24
//        targetSdk 35
//        versionCode 1
//        versionName "1.0"
//    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            // Evita gerar anotações de lint
            withJavadocJar()
        }
    }
}

//repositories {
//    flatDir {
//        dirs("libs")
//    }
//}

//dependencies {
//    implementation(name = "seu_sdk_flutter", ext = "aar") // sem extensão no nome do arquivo
//}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.lcsz"
                artifactId = "kyc_sdk_android"
                version = "v1.0.0"

                from(components["release"])
            }
        }
    }
}

tasks.withType<org.gradle.api.tasks.bundling.Jar>().configureEach {
    // Evita incluir javadoc/lint desnecessários
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}