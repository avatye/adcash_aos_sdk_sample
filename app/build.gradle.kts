plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "adcash.aos.sdk.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "adcash.aos.sdk.sample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val adcashVersion = "2.1.0.14"
    implementation ("com.avatye.cashblock:unit-adcash:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-basement:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-adpopcorn:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-adfit:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-admob:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-applovin:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-cauly:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-fan:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-fyber:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-mezzomedia:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-mobon:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-nam:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-pangle:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-unity:${adcashVersion}")
    implementation ("com.avatye.cashblock:ad-plus-vungle:${adcashVersion}")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}