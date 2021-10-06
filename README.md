# ShadowJar task cacheability reproducer

Reproducer for a cacheability problem in the cacheable ShadowJar task, in which the task is considered up-to-date when
it should not be. When the set of exclusions is changed for the task's CopySpec, the task should no longer be considered
up-to-date. Currently though, the task is considered up-to-date.

In `build.gradle.kts` there is a walk-through for reproducing the problem.
