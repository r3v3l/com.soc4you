import play.sbt.PlayImport._

name := """user"""

version := "1.0.1-SNAPSHOT"

lazy val user = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

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

playEbeanModels in Compile := Seq("models.*")
playEbeanDebugLevel := 4
playEbeanAgentArgs += ("detect" -> "false")
playEbeanModels in Test := Seq("models.*")
javaOptions in Test ++= Seq(
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9997",
  "-Xms512M",
  "-Xmx1536M",
  "-Xss1M",
  "-XX:MaxPermSize=384M"
)