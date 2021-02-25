name := "advent2015"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)