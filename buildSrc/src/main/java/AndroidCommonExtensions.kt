import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun BaseExtension.setSdkVersions() {
    compileSdkVersion(Versions.Android.sdk)
    defaultConfig {
        targetSdkVersion(Versions.Android.sdk)
        minSdkVersion(Versions.Android.minSdk)
    }
}

fun BaseExtension.createBuildTypes() {
    buildTypes {
        create("internal")
        create("alpha")
        create("beta")
        create("preview")
    }
}

fun BaseExtension.setJvmVersions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    val kotlinJvmOptions = (this as ExtensionAware).extensions.getByName("kotlinOptions") as KotlinJvmOptions
    kotlinJvmOptions.jvmTarget = "1.8"
}

fun BaseExtension.disableAbortOnErrorForLint() {
    lintOptions {
        isAbortOnError = false
    }
}

fun BaseExtension.disableMissingTranslationLint() {
    lintOptions {
        disable("MissingTranslation")
    }
}