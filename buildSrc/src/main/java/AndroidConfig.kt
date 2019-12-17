object AndroidConfig {

    const val APPLICATION_ID = "dev.tigrao"

    const val COMPILE_SDK = 29
    const val MIN_SDK = 21
    const val TARGET_SDK = COMPILE_SDK
    const val INSTRUMENTATION_TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val JAVA_VERSION = 1.8
}

object Source {
    const val MAIN = "src/main/kotlin"
    const val TEST = "src/test/kotlin"
}

object RepositoriesUri {
    const val SONATYPE = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val JITPACK = "https://jitpack.io"
    const val SAFE_ROOM = "https://s3.amazonaws.com/repo.commonsware.com"
}
