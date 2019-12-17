package dependencies

object TestDependencies {
    val JUNIT = "junit:junit:${Versions.JUNIT}"
    val JUNIT_EXT = "androidx.test.ext:junit:1.1.0"
    val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${PluginsVersions.KOTLIN}"
    val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
    val MOCKITO_ANDROID = "org.mockito:mockito-android:${Versions.MOCKITO}"
    val TEST_RULES = "androidx.test:rules:1.1.0"
    val MOCKSERVER = "com.squareup.okhttp3:mockwebserver:${Versions.OKHTTP}"
    val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.FRAGMENT}"
    val MOCKITO_INLINE = "org.mockito:mockito-inline:${Versions.MOCKITO}"
    val CORE_TEST = "androidx.test:core:${Versions.CORE_TEST}"
}
