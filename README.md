# ShadowJar task cacheability reproducer

Reproducer for a cacheability problem in the cacheable ShadowJar task, in which the task is considered up-to-date when
it should not be. When the set of exclusions is changed for the task's CopySpec, the task should no longer be considered
up-to-date. Currently though, the task is considered up-to-date.

In `build.gradle.kts` there is a walk-through for reproducing the problem. It's repeated here:

```
/**
 * Reproducer Guide:
 *
 * This task's input fingerprint should change when the set of excludes changes.
 *
 * Try:
 * 1. Run `./gradlew shadowJar`. You should see `2 actionable tasks: 2 executed`.
 * 2. Re-run. You should see `2 actionable tasks: 2 up-to-date`.
 * 3. Uncomment the first line in the ShadowJar task configuration block.
 * 4. Re-run. You'll see the log line, and (incorrectly) `2 actionable tasks: 2 up-to-date`.
 * 5. Re-comment the first line in the ShadowJar task configuration block, and uncomment the second line.
 * 6. Re-run. As before, you'll see the log line and (incorrectly) `2 actionable tasks: 2 up-to-date`.
 *
 * Reset with `./gradlew clean`.
 */
```
