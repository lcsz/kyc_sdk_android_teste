plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    publishing {
        singleVariant("release")
    }
}

repositories {
    flatDir {
        dirs("libs")
    }
}

dependencies {
    implementation(name = "seu_sdk_flutter", ext = "aar") // sem extensão no nome do arquivo
}

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
