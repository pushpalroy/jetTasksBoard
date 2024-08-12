plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id("org.jetbrains.kotlin.android")
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id("com.google.devtools.ksp")

    alias(libs.plugins.compose)
}

android {
    namespace = "com.jetapps.jettaskboard.feature.search"
    compileSdk = (ProjectProperties.COMPILE_SDK)

    defaultConfig {
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-common.txt",
                "proguard-specific.txt"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.navigation)
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)

    /* Android Designing and layout */
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.kotlin.stdlib)
    implementation(libs.compose.material)
    implementation(libs.androidx.compose.constraint.layout)
    implementation(libs.androidx.compose.accompanist.insets)
    implementation(libs.androidx.compose.accompanist.insets.ui)
    implementation(libs.androidx.compose.accompanist.flow.layout)
    implementation(libs.accompanist.adaptive)
    implementation(libs.androidx.window)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.tooling)

    /* Image Loading */
    implementation(libs.coil.kt)

    /* DI */
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    /* Profile Installer */
    implementation(libs.androidx.profileinstaller)

    /* Logger */
    implementation(libs.timber)

    /* Async */
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /* Room */
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.paging)

    /*Testing*/
    implementation(libs.androidx.test.runner)
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.arch.core)
    testImplementation(libs.robolectric)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.hilt.android.testing)
    debugImplementation(libs.androidx.compose.ui.testManifest)
//    testImplementation(libs.androidx.test.ext.junit)
}
