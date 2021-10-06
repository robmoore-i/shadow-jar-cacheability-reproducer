import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow").version("7.1.0")
}

/**
 * Reproducer Guide:
 *
 * This task's input fingerprint should change when the set of excludes changes.
 *
 * Try:
 * 1. Run `./gradlew shadowJar`. You should see `2 actionable tasks: 2 executed`.
 * 2. Re-run. You should see `2 actionable tasks: 2 up-to-date`.
 * 3. Uncomment line 24.
 * 4. Re-run. You'll see the log line, and (incorrectly) `2 actionable tasks: 2 up-to-date`.
 * 5. Re-comment line 24, and uncomment line 25.
 * 6. Re-run. As before, you'll see the log line and (incorrectly) `2 actionable tasks: 2 up-to-date`.
 *
 * Reset with `./gradlew clean`.
 */
tasks.named<ShadowJar>("shadowJar") {
//    logger.quiet("Excluding 1"); exclude("META-INF/maven/com.google.j2objc/")
//    logger.quiet("Excluding 2"); exclude("META-INF/maven/com.google.j2objc/", "META-INF/maven/com.google.errorprone/")
}

group = "com.reproducer"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.0.1-jre")
}
