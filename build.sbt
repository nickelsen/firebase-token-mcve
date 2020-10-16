import Dependencies._

lazy val commonSettings = Seq(
  version := "1.0",
  organization := "com.leoilab",
  scalaVersion := "2.13.3",
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= dependencies,
  )
