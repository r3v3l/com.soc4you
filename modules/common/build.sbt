import play.sbt.PlayImport._

name := """common"""

version := "1.0.0-SNAPSHOT"

lazy val common = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  filters,
  "mysql" % "mysql-connector-java" % "5.1.39",
  "javax.mail" % "mail" % "1.5.0-b01",
  "javax.mail" % "javax.mail-api" % "1.5.6"
)