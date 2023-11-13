ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

val zioVersion = "2.0.15"

lazy val root = (project in file("."))
  .settings(
    name := "ZioTestAoc"
  )

libraryDependencies ++= Seq(
  "dev.zio"       %% "zio"            % zioVersion
)