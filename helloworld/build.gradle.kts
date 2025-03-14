import com.vanniktech.maven.publish.SonatypeHost
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.31.0"
    id("com.gradleup.nmcp") version "0.0.8"
}

android {
    namespace = "io.github.prathamngundikere.helloworld"
    compileSdk = 35

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}

mavenPublishing {
    coordinates("io.github.prathamngundikere", "helloworld", "1.0.0")

    pom {
        name.set("Hello World")
        description.set("Android Library to import the Hello World Text")
        inceptionYear.set("2025")
        url.set("https://github.com/prathamngundikere/HelloWorld_Android_Library/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("prathamngundikere")
                name.set("PRATHAM N GUNDIKERE")
                url.set("https://github.com/prathamngundikere/")
            }
        }
        scm {
            url.set("https://github.com/prathamngundikere/HelloWorld_Android_Library/")
            connection.set("scm:git:git://github.com/prathamngundikere/HelloWorld_Android_Library.git")
            developerConnection.set("scm:git:ssh://git@github.com/prathamngundikere/HelloWorld_Android_Library.git")
        }
    }
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
}