val scala3Version = "3.4.2"

lazy val dependencyProject = RootProject(file("../jit_poc"))

lazy val root = (project in file("."))
  .dependsOn(dependencyProject)
  .settings(
    name := "dynamic_lib",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
