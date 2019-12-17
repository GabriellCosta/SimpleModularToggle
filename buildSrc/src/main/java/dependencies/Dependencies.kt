package dependencies

object Dependencies {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${PluginsVersions.KOTLIN}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val PICASSO = "com.squareup.picasso:picasso:${Versions.PICASSO}"
    const val SAFE_ROOM = "com.commonsware.cwac:saferoom.x:${Versions.SAFE_ROOM}"

    object Android {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val FRAGMENT = "androidx.fragment:fragment:${Versions.FRAGMENT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val CORE_COMMON = "androidx.arch.core:core-common:${Versions.CORE_ARCH}"
        const val CORE_RUNTIME = "androidx.arch.core:core-runtime:${Versions.CORE_ARCH}"
        const val ANNOTATION = "androidx.annotation:annotation:${Versions.ANNOTATION}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    }

    object Lifecycle {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel:${Versions.LIFECYCLE}"
        const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata:${Versions.LIFECYCLE}"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE}"
        const val EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
        const val COMPILER = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    }

    object Kodein {
        const val GENERIC = "org.kodein.di:kodein-di-generic-jvm:${Versions.KODEIN}"
        const val CONF = "org.kodein.di:kodein-di-conf-jvm:${Versions.KODEIN}"
        const val ANDROID = "org.kodein.di:kodein-di-framework-android-x:${Versions.KODEIN}"
    }

    object Room {
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    }
}
