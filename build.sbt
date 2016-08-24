name := """com.soc4you"""

version := "1.0.5-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean).dependsOn(common, user).aggregate(common, user)

lazy val common = (project in file("modules/common")).enablePlugins(PlayJava, PlayEbean)

lazy val user = (project in file("modules/user")).enablePlugins(PlayJava, PlayEbean).dependsOn(common).aggregate(common)

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
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9998",
  "-Xms512M",
  "-Xmx1536M",
  "-Xss1M",
  "-XX:MaxPermSize=384M"
)
