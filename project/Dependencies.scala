import sbt._

object Dependencies {

  lazy val dependencies: Seq[ModuleID] = Seq(
    "com.google.auth" % "google-auth-library-oauth2-http" % "0.20.0",
    "com.google.firebase" % "firebase-admin" % "7.0.0",
  )
}
