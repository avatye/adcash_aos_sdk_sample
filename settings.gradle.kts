pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://artifact.bytedance.com/repository/pangle") }
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/") }
        maven { url = uri("https://dl.cloudsmith.io/public/avatye/Android-CashBlock/maven/") }
        maven {
            url = uri("s3://repo.cauly.net/releases")
            credentials(AwsCredentials::class.java) {
                accessKey = "AKIAWRZUK5MFKYVSUOLB"
                secretKey = "SGOr65MOJeKBUFxeVNZ4ogITUKvcltWqEApC41JL"
            }
        }
    }
}

rootProject.name = "adcash_aos_sdk_sample"
include(":app")
 